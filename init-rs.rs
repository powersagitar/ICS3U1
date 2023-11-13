fn main() {
    let args = std::env::args().collect::<Vec<String>>();

    if args.len() < 2 {
        eprintln!("Usage: path to java source file is not given");
        return;
    }

    let path_to_java_src = &args[1];

    let mut dockerfile_contents = String::new();
    dockerfile_contents.push_str("FROM openjdk:21-jdk as development\n");
    dockerfile_contents.push_str("WORKDIR /app\n");
    dockerfile_contents.push_str("COPY . .\n");
    // dockerfile_contents.push_str("RUN javac Main.java\n");
    dockerfile_contents.push_str(("RUN javac \"".to_owned() + path_to_java_src + "\"\n").as_str());
    // dockerfile_contents.push_str("CMD [\"java\", \"Main\"]\n");
    dockerfile_contents
        .push_str(("CMD [\"java\", \"".to_owned() + path_to_java_src + "\"]\n").as_str());

    let dockerfile_path = std::path::Path::new("./Dockerfile");

    let mut input = String::new();
    println!("Creating Dockerfile at {dockerfile_path:?}. Proceed? [y/n]");
    std::io::stdin().read_line(&mut input).unwrap();

    if input.trim() != "y" {
        println!("Aborting.");
        return;
    }

    let mut dockerfile = std::fs::File::create(dockerfile_path).unwrap();

    use std::io::Write;
    dockerfile
        .write_all(dockerfile_contents.as_bytes())
        .unwrap();
}
