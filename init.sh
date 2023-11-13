#!/bin/zsh

if [[ ! -f "./init-rs.rs" ]]; then
	echo "./init-rs.rs not found"
	exit
fi

rustc ./init-rs.rs -O -o init-rs
