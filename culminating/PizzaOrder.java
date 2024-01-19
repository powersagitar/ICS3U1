/**
 * Project: Pizza Order - ICS3U1 Culminating Project
 * Author:  Mohan Dong <350877700@gapps.yrdsb.ca>
 * Date:    01/19/2024
 *
 * Description:
 * This program allows users to order pizzas with different crusts and toppings. There are preset pizzas as well as a
 * custom order available. This program will display the order summary and the total cost at the end of the order.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.text.DecimalFormat;

/**
 * The solution class to the Pizza Order culminating project.
 * The functionalities of this class is described in header comments.
 *
 * ----------------------------------------------------------------------------
 *
 * Constants
 *
 * - INT_ARRAY_DELETED_ELEMENT (int) - This value is used to indicate that an
 * element in an int array has been flagged as deleted.
 *
 * - INDEX_INVALID (int) - This value will be returned when an index is invalid,
 * including the case where the index is not able to be retrieved.
 *
 * - MENU (String[]) - A list of all available pizza types.
 *
 * - DESCRIPTIONS (String[]) - A list of descriptions of all available pizza
 * types.
 *
 * - PRICE_BASE (double[]) - A list of base prices of all available pizza types.
 *
 * - CRUST_LIST (String[][]) - A list of all available crust types for each
 * pizza type.
 *
 * - CRUST_IS_VEGGIE (boolean[][]) - A list to indicate whether each crust type
 * is a veggie option for each pizza type.
 *
 * - PRICE_VARIATION_CRUST (double[][]) - A list of price variations of all
 * available crust types for each pizza type. A positive value indicates an
 * price increase, while a negative value indicates a price decrease.
 *
 * - TOPPING_LIST (String[][]) - A list of all available toppings for each pizza
 * type.
 *
 * - TOPPING_IS_VEGGIE (boolean[][]) - A list to indicate whether each topping
 * is a veggie option for each pizza type.
 *
 * - PRICE_VARIATION_TOPPING (double[][]) - A list of price variations of all
 * available toppings for each pizza type. A positive value indicates an price
 * increase, while a negative value indicates a price decrease.
 *
 * Variables
 *
 * - stdinReader (BufferedReader) - The buffered reader used to read from stdin.
 */
public class PizzaOrder {
    /**
     * Stdin reader is defined as a member variable for maintainability since it is
     * used in various member methods.
     */
    BufferedReader stdinReader = new BufferedReader(new InputStreamReader(System.in));

    // All errors codes related to arrays and indices should be negative to avoid
    // possible errors

    /**
     * This value is used to indicate that an element in an int array has been
     * flagged as deleted.
     */
    final int INT_ARRAY_DELETED_ELEMENT = Integer.MIN_VALUE;

    /**
     * This value will be returned when an index is invalid, including the case
     * where the index is not able to be
     * retrieved.
     */
    final int INDEX_INVALID = -1;

    // Data

    /**
     * A list of all available pizza types.
     */
    final String MENU[] = {
            "Margherita",
            "Pepperoni",
            "BBQ Chicken",
            "Hawaiian",
            "Buffalo\t",
            "Custom\t",
    };

    /**
     * A list of descriptions of all available pizza types.
     */
    final String DESCRIPTIONS[] = {
            "Deceptively simple, the Margherita pizza is made with basil, fresh mozzarella, and tomatoes.",
            "Who doesn't love biting into a crispy, salty round of pepperoni?",
            "If you love BBQ chicken and you love pizza, why not put them together? This has long been a cult favorite of sports fans and college kids. The chicken slathered over the top of a pie gives it a tangy, sweet flavor that can't be beaten.",
            "Pineapple might not be the first thing that comes to mind when you think pizza. But add in some ham and it creates and unexpectedly solid sweet and salty combination for this type of pizza.",
            "Who says your pizza has to be strictly tomato-sauce based? Branch out with some buffalo sauce on your pie. All its spicy, buttery goodness is a natural pairing for pizza.",
            "A pizza tailored for, and created by you."
    };

    /**
     * A list of base prices of all available pizza types.
     */
    final double PRICE_BASE[] = {
            7.0,
            7.0,
            7.0,
            7.0,
            7.0,
            7.0,
    };

    /**
     * A list of all available crust types for each pizza type.
     */
    final String CRUST_LIST[][] = {
            { "Thin" },
            { "Thick" },
            { "Stuffed" },
            { "Thin" },
            { "Thick" },
            { "Thin", "Thick", "Stuffed" },
    };

    /**
     * A list to indicate whether each crust type is a veggie option for each pizza
     * type.
     */
    final boolean CRUST_IS_VEGGIE[][] = {
            { true },
            { false },
            { false },
            { true },
            { false },
            { true, false, false },
    };

    /**
     * A list of price variations of all available crust types for each pizza type.
     * A positive value indicates an price
     * increase, while a negative value indicates a price decrease.
     */
    final double PRICE_VARIATION_CRUST[][] = {
            { 0.0 },
            { 0.5 },
            { 0.5 },
            { 0.0 },
            { 0.5 },
            { 0.0, 0.5, 0.5 },
    };

    /**
     * A list of all available toppings for each pizza type.
     */
    final String TOPPING_LIST[][] = {
            { "Mozzarella", "Tomato\t", "Basil\t" },
            { "Pepperoni", "Cheese\t" },
            { "BBQ Chicken", "Mozzarella", "Smoked Gouda", "Red Onion" },
            { "Pineapple", "Ham\t", "Cheese\t", "Bell Peppers", "Mushrooms", "Bacon\t", "Chicken\t" },
            { "Chicken\t", "Cheese\t", "Ranch Dressing", "Green Onion" },
            { "Mozzarella", "Tomato\t", "Pepperoni", "Pineapple", "Bell Peppers", "Mushrooms", "Shrimp\t", "Basil\t",
                    "Beetroot", "Spinach\t", "Bacon\t", "Chicken\t" }
    };

    /**
     * A list to indicate whether each topping is a veggie option for each pizza
     * type.
     */
    final boolean TOPPING_IS_VEGGIE[][] = {
            { true, true, true },
            { false, false },
            { false, true, true, true },
            { true, false, true, true, true, false, false },
            { false, true, true, true },
            { true, true, false, true, true, true, false, true, true, true, false, false }
    };

    /**
     * A list of price variations of all available toppings for each pizza type. A
     * positive value indicates an price
     * increase, while a negative value indicates a price decrease.
     */
    final double PRICE_VARIATION_TOPPING[][] = {
            { 2.0, 0.5, 0.1 },
            { 2.0, 1.0 },
            { 2.0, 0.3, 0.3, 0.2 },
            { 1.0, 1.0, 0.5, 0.1, 0.1, 0.5, 1.0 },
            { 1.0, 0.5, 0.1, 0.2 },
            { 1.0, 0.2, 1.0, 1.0, 0.2, 0.1, 1.5, 0.1, 0.1, 0.2, 1.0, 1.0 }
    };

    /**
     * The entry point of the program.
     * Get the pizza type, crust type, and topping types from the user, calculate
     * the subtotal and HST, and print the
     * order summary, i.e., receipt.
     *
     * ----------------------------------------------------------------------------
     *
     * Variables
     *
     * - pizzaOrder (PizzaOrder) - The PizzaOrder object used to access non-static
     * methods and variables.
     *
     * - pizzaType (int) - The pizza type the user selected.
     *
     * - crustType (int) - The crust type the user selected.
     *
     * - toppingTypes (int[]) - The topping types the user selected.
     *
     * - subtotal (double) - The subtotal of the user's order.
     *
     * - hst (double) - The HST of the user's order.
     *
     * ----------------------------------------------------------------------------
     *
     * @param args Command line arguments, unused.
     */
    public static void main(String[] args) {
        PizzaOrder pizzaOrder = new PizzaOrder();

        int pizzaType = pizzaOrder.getPizzaType();
        int crustType = pizzaOrder.getCrustType(pizzaType);
        int toppingTypes[] = pizzaOrder.getToppingTypes(pizzaType);

        double subtotal = pizzaOrder.calculateSubtotal(pizzaType, crustType, toppingTypes);
        double hst = subtotal * 0.13;

        pizzaOrder.printOrderSummary(pizzaType, crustType, toppingTypes, subtotal, hst);
    }

    // IO helper methods

    /**
     * Clears the terminal screen.
     */
    private void clearScreen() {
        // \033[H moves the cursor to the top left corner of the screen
        // \033[2J clears the screen from the cursor to the end of the screen
        System.out.print("\033[H\033[2J");

        // Stdout sometimes will not be flushed when printing out control characters
        System.out.flush();
    }

    /**
     * Reads a line from the specified BufferedReader. If an IOException is thrown,
     * the user will be greeted with an
     * error message and prompted to try again. If IOException keeps being thrown,
     * this method will cause a dead loop.
     *
     * ----------------------------------------------------------------------------
     *
     * Variables
     *
     * - e (IOException) - The IOException thrown by BufferedReader::readLine().
     *
     * ----------------------------------------------------------------------------
     *
     * @param bufferedReader The BufferedReader to read from.
     * @return The line read from the BufferedReader.
     */
    private String readLine(BufferedReader bufferedReader) {
        while (true) {
            try {
                return bufferedReader.readLine();
            } catch (IOException e) {
                System.out.println("Failed to read input: " + e.getLocalizedMessage());
            }
        }
    }

    /**
     * Reads an index (int) from the specified BufferedReader. If a
     * NumberFormatException is thrown, method will return
     * INDEX_INVALID to indicate the error.
     *
     * ----------------------------------------------------------------------------
     *
     * Variables
     *
     * - e (NumberFormatException) - The NumberFormatException thrown by
     * Integer::parseInt().
     *
     * ----------------------------------------------------------------------------
     *
     * @param bufferedReader The BufferedReader to read from.
     * @return The index read from the BufferedReader, or INDEX_INVALID if an error
     *         occurred.
     */
    private int readIndexInput(BufferedReader bufferedReader) {
        try {
            return Integer.parseInt(readLine(bufferedReader));
        } catch (NumberFormatException e) {
            return INDEX_INVALID;
        }
    }

    /**
     * Validates the index input. If the input is invalid, the user will be greeted
     * with an error message and the method will return false. Otherwise, the method
     * will return true.
     *
     * The step of range validation is 1. E.g., if rangeMinInclusive is 1 and
     * rangeMaxInclusive is 3, then inputs of all 1, 2, and 3, are valid.
     *
     * @param input             The index input to validate.
     * @param rangeMinInclusive The minimum index value (inclusive).
     * @param rangeMaxInclusive The maximum index value (inclusive).
     * @return True if the input is valid, false otherwise.
     */
    private boolean validateIndexInput(int input, int rangeMinInclusive, int rangeMaxInclusive) {
        if (input == INDEX_INVALID) {
            // NumberFormatException is thrown by Integer::parseInt(), therefore input has a
            // value of INDEX_INVALID
            System.out.println("Input is not a valid index. Enter an index to select.");
        } else if (!indexInRange(input, rangeMinInclusive, rangeMaxInclusive)) {
            System.out.println(
                    "Input is out of range. Please enter an index that is within the range (" + rangeMinInclusive + "-"
                            + rangeMaxInclusive + ")");
        } else {
            return true;
        }

        System.out.println("Press enter to continue.");
        readLine(stdinReader);

        return false;
    }

    // Algorithm helper methods

    /**
     * Searches for the target int in the specified array. If the target is found,
     * the index of the target will be returned, otherwise INDEX_INVALID will be
     * returned.
     *
     * ----------------------------------------------------------------------------
     *
     * Variables
     *
     * - i (int) - The index of the current element in the array.
     *
     * ----------------------------------------------------------------------------
     *
     * @param arr    The array to search in.
     * @param target The target to search for.
     * @return The index of the target if found, otherwise INDEX_INVALID.
     */
    private int linearSearchInt(int arr[], int target) {
        for (int i = 0; i < arr.length; ++i) {
            // For performance reasons, deleted elements are not actually deleted from the
            // array but rather flagged as
            // deleted, the flag is INT_ARRAY_DELETED_ELEMENT
            if (arr[i] == INT_ARRAY_DELETED_ELEMENT)
                continue;

            if (arr[i] == target)
                return i;
        }

        return INDEX_INVALID;
    }

    /**
     * Checks if the specified element is deleted.
     * 
     * @param arr   The int array to check.
     * @param index The index of the element to check.
     * @return True if the element is deleted, false otherwise.
     */
    private boolean intElementIsDeleted(int arr[], int index) {
        return arr[index] == INT_ARRAY_DELETED_ELEMENT;
    }

    /**
     * Converts an index to a boolean value. If the index is negative, false will be
     * returned, otherwise true will be returned.
     *
     * @param index The index to convert.
     * @return True if the index is non-negative, false otherwise.
     */
    private boolean indexToBool(int index) {
        return index >= 0;
    }

    /**
     * Checks if the input is within the specified range (inclusive).
     *
     * @param index        The index to check.
     * @param minInclusive The minimum index value (inclusive).
     * @param maxInclusive The maximum index value (inclusive).
     * @return True if the index is within the range, false otherwise.
     */
    private boolean indexInRange(int index, int minInclusive, int maxInclusive) {
        return index >= minInclusive && index <= maxInclusive;
    }

    // Array helper methods

    /**
     * Appends an element to the end of the specified array. A new array that has a
     * length of oldArray.length + 1 with the appended element will be returned.
     *
     * ----------------------------------------------------------------------------
     *
     * Variables
     *
     * - newArr (int[]) - The new array with the appended element.
     *
     * - i (int) - The index of the current element in the old array.
     *
     * ----------------------------------------------------------------------------
     *
     * @param oldArr  The array to append to.
     * @param element The element to append.
     * @return The new array with the appended element.
     */
    private int[] appendElement(int oldArr[], int element) {
        int newArr[] = new int[oldArr.length + 1];

        for (int i = 0; i < oldArr.length; ++i)
            newArr[i] = oldArr[i];

        newArr[oldArr.length] = element;

        return newArr;
    }

    /**
     * Deletes the element at the specified index in the specified array in place.
     * Due to performance reasons, the element will not actually be deleted, but
     * rather flagged as deleted. All flagged deleted elements have a value of
     * INT_ARRAY_DELETED_ELEMENT.
     *
     * @param arr   The array to delete from.
     * @param index The index of the element to delete.
     */
    private void deleteElement(int arr[], int index) {
        arr[index] = INT_ARRAY_DELETED_ELEMENT;
    }

    // Program logic helper methods

    /**
     * Converts a double representing money to a string with a dollar sign and two
     * decimal places. If the double is negative, the minus sign will be moved to
     * before the dollar sign.
     *
     * ----------------------------------------------------------------------------
     *
     * Variables
     * - moneyRounded (String) - The string representation of the double with two
     * decimal places.
     *
     * ----------------------------------------------------------------------------
     *
     * @param moneyDouble The double representing money.
     * @return The string with a dollar sign and two decimal places. If the double
     *         is negative, the minus sign will be moved to before the dollar sign.
     */
    private String moneyDoubleToString(double moneyDouble) {
        String moneyRounded = new DecimalFormat("0.00").format(moneyDouble);

        if (moneyRounded.startsWith("-"))
            // substring(1) removes the minus sign
            return "-$" + moneyRounded.substring(1);
        else
            return "$" + moneyRounded;
    }

    /**
     * Checks if the specified pizza type is a custom pizza.
     *
     * @param pizzaType The pizza type to check.
     * @return True if the pizza type is a custom pizza, false otherwise.
     */
    private boolean isCustomPizza(int pizzaType) {
        // Using String::startsWith() since the name may contain tabs and spaces to
        // align with other menu items
        return MENU[pizzaType].startsWith("Custom");
    }

    /**
     * Calculates the subtotal of the specified pizza type, crust type, and topping
     * types.
     *
     * ----------------------------------------------------------------------------
     *
     * Variables
     *
     * - subtotal (double) - The sum of the prices of specified pizza type, crust
     * type, and topping types.
     *
     * - i (int) - The index of the current topping type.
     *
     * ----------------------------------------------------------------------------
     *
     * @param pizzaType    The pizza type to calculate the subtotal of.
     * @param crustType    The crust type to calculate the subtotal of.
     * @param toppingTypes The topping types to calculate the subtotal of.
     * @return The sum of the prices of specified pizza type, crust type, and
     *         topping types.
     */
    private double calculateSubtotal(int pizzaType, int crustType, int toppingTypes[]) {
        double subtotal = PRICE_BASE[pizzaType] + PRICE_VARIATION_CRUST[pizzaType][crustType];

        for (int i = 0; i < toppingTypes.length; ++i) {
            if (!intElementIsDeleted(toppingTypes, i))
                subtotal += PRICE_VARIATION_TOPPING[pizzaType][toppingTypes[i]];
        }

        return subtotal;
    }

    /**
     * Checks if the specified selection is a veggie option.
     *
     * @param selection    The selection to check. The selection is represented by
     *                     its index.
     * @param isVeggieList The list of booleans indicating whether each selection is
     *                     a veggie option.
     * @return True if the selection is a veggie option, false otherwise.
     */
    private boolean isVeggie(int selection, boolean isVeggieList[]) {
        return isVeggieList[selection];
    }

    /**
     * Prompts the user to confirm the non-veggie selection. If the user confirms,
     * true will be returned. If the user
     * failed to confirm or denied, false will be returned.
     *
     * ----------------------------------------------------------------------------
     *
     * Variables
     *
     * - confirmation (String) - The user's input regarding confirmation.
     *
     * ----------------------------------------------------------------------------
     *
     * @return True if confirmation is valid and positive, false otherwise.
     */
    private boolean confirmNonVeggieSelection() {
        System.out.println("Selection is non-veggie. Are you sure you want to include it in your order? (y/n)");
        String confirmation = readLine(stdinReader);

        if (confirmation.equals("y") || confirmation.equals("Y")) {
            return true;
        } else if (confirmation.equals("n") || confirmation.equals("N")) {
            return false;
        } else {
            System.out.println("Invalid input. Treated as if input was n.");
            System.out.println("Press enter to continue.");
            readLine(stdinReader);
            return false;
        }
    }

    /**
     * Checks if the specified array of items contains non-veggie items.
     *
     * ----------------------------------------------------------------------------
     *
     * Variables
     *
     * - i (int) - The index of the current item.
     *
     * ----------------------------------------------------------------------------
     *
     * @param items        The array of items to check. The items are represented by
     *                     their indices.
     * @param isVeggieList The list of booleans indicating whether each item is a
     *                     veggie option.
     * @return True if the array of items contains non-veggie items, false
     *         otherwise.
     */
    private boolean orderIncludesNonVeggieItems(int items[], boolean isVeggieList[]) {
        for (int i = 0; i < items.length; ++i) {
            // Deleted elements are assigned to INT_ARRAY_DELETED_ELEMENT instead of
            // actually being deleted from the array
            if (items[i] == INT_ARRAY_DELETED_ELEMENT)
                continue;

            if (!isVeggie(items[i], isVeggieList))
                return true;
        }

        return false;
    }

    // Program logic methods

    /**
     * Prints the itemized price list. Descriptions will only be printed if the
     * length of the item descriptions array is the same as the length of the items
     * array.
     *
     * ----------------------------------------------------------------------------
     *
     * Variables
     *
     * - i (int) - The index of the current item.
     *
     * ----------------------------------------------------------------------------
     *
     * @param listName         The name of the list.
     * @param items            The items in the list.
     * @param itemDescriptions The descriptions of the items in the list.
     * @param prices           The prices of the items in the list.
     * @param selectedItems    The selected items in the list.
     */
    private void printItemPriceList(String listName, String items[], String itemDescriptions[], double prices[],
            int selectedItems[]) {
        System.out.println(listName + "\n");

        for (int i = 0; i < items.length; ++i) {
            // Wrap the index in brackets if the item is selected
            if (indexToBool(linearSearchInt(selectedItems, i)))
                System.out.print("[" + (i + 1) + ".]");
            else
                System.out.print(i + 1 + ".");

            System.out.println("\t" + items[i] + "\t" + moneyDoubleToString(prices[i]));

            if (itemDescriptions.length == items.length)
                System.out.println("\t" + itemDescriptions[i] + "\n");
        }

        System.out.println();
    }

    /**
     * Prints the order summary. Total will be calculated automatically using
     * formula (total = subtotal + hst).
     *
     * ----------------------------------------------------------------------------
     *
     * Variables
     *
     * - hasToppings (boolean) - Indicates whether the order has toppings.
     *
     * - i (int) - The index of the current topping type.
     *
     * ----------------------------------------------------------------------------
     *
     * @param pizzaType    The pizza type the user ordered.
     * @param crustType    The crust type the user ordered.
     * @param toppingTypes The topping types the user ordered.
     * @param subtotal     The subtotal of the user's order.
     * @param hst          The HST of the user's order.
     */
    private void printOrderSummary(int pizzaType, int crustType, int toppingTypes[], double subtotal, double hst) {
        clearScreen();

        System.out.println("Order Summary");

        System.out.println();

        System.out.println("Pizza:\t" + MENU[pizzaType] + "\t" + moneyDoubleToString(PRICE_BASE[pizzaType]));

        System.out.println("Crust:\t" + CRUST_LIST[pizzaType][crustType] + "\t\t"
                + moneyDoubleToString(PRICE_VARIATION_CRUST[pizzaType][crustType]));

        System.out.println("Toppings:");

        // cannot use toppingTypes.length to check if order has toppings because deleted
        // elements are assigned to
        // INT_ARRAY_DELETED_ELEMENT instead of actually being deleted from the array
        boolean hasToppings = false;

        for (int i = 0; i < toppingTypes.length; ++i)
            if (!intElementIsDeleted(toppingTypes, i)) {
                System.out.println("\t" + TOPPING_LIST[pizzaType][toppingTypes[i]] + "\t"
                        + moneyDoubleToString(PRICE_VARIATION_TOPPING[pizzaType][toppingTypes[i]]));
                hasToppings = true;
            }

        if (!hasToppings)
            System.out.println("\t(None)");

        System.out.println();

        System.out.println("Subtotal:\t\t" + moneyDoubleToString(subtotal));
        System.out.println("HST:\t\t\t" + moneyDoubleToString(hst));
        System.out.println("Total:\t\t\t" + moneyDoubleToString(subtotal + hst));

        System.out.println();

        if (orderIncludesNonVeggieItems(new int[] { crustType }, CRUST_IS_VEGGIE[pizzaType]))
            System.out.println("Order contains non-veggie crust.");

        if (orderIncludesNonVeggieItems(toppingTypes, TOPPING_IS_VEGGIE[pizzaType]))
            System.out.println("Order contains non-veggie toppings.");
    }

    /**
     * Gets the pizza type from the user.
     *
     * ----------------------------------------------------------------------------
     *
     * Variables
     *
     * - input (int) - The 1-based index input from the user.
     *
     * ----------------------------------------------------------------------------
     *
     * @return The pizza type the user selected.
     */
    private int getPizzaType() {
        while (true) {
            clearScreen();

            printItemPriceList("Pizzas", MENU, DESCRIPTIONS, PRICE_BASE, new int[0]);

            System.out.println("Which pizza would you like to order? Enter the index to select.");

            // input is an 1-based index
            int input = readIndexInput(stdinReader);

            if (!validateIndexInput(input, 1, MENU.length))
                continue;

            return input - 1;
        }
    }

    /**
     * Gets the crust type from the user.
     *
     * ----------------------------------------------------------------------------
     *
     * Variables
     *
     * - input (int) - The 1-based index input from the user.
     *
     * ----------------------------------------------------------------------------
     *
     * @param pizzaType The pizza type the user selected.
     * @return The 0-based crust type the user selected.
     */
    private int getCrustType(int pizzaType) {
        if (isCustomPizza(pizzaType)) {
            while (true) {
                clearScreen();

                printItemPriceList("Crusts", CRUST_LIST[pizzaType], new String[0], PRICE_VARIATION_CRUST[pizzaType],
                        new int[] {});

                System.out.println("Select your preferred crust by index.");

                // input is an 1-based index
                int input = readIndexInput(stdinReader);

                if (!validateIndexInput(input, 1, CRUST_LIST[pizzaType].length))
                    continue;

                if (!isVeggie(input - 1, CRUST_IS_VEGGIE[pizzaType]))
                    if (!confirmNonVeggieSelection())
                        continue;

                return input - 1;
            }
        } else {
            clearScreen();

            printItemPriceList("Crusts", CRUST_LIST[pizzaType], new String[0], PRICE_VARIATION_CRUST[pizzaType],
                    new int[] { 0 });

            System.out.println(
                    "This is the crust from the pizza you selected. You will not be able to change the selections. If you want to do so, order a Custom pizza instead.");
            System.out.println("Press enter to proceed.");

            readLine(stdinReader);

            return 0;
        }
    }

    /**
     * Gets the topping types from the user.
     *
     * ----------------------------------------------------------------------------
     *
     * Variables
     *
     * - selectedToppings (int[]) - The array of selected topping types.
     *
     * - input (int) - The 1-based index input from the user.
     *
     * - inputInSelectedToppings (int) - The index of the input in the array of
     * selected topping types.
     *
     * - i (int) - The index of the current topping type.
     *
     * ----------------------------------------------------------------------------
     *
     * @param pizzaType The pizza type the user selected.
     * @return An array of 0-based topping types the user selected.
     */
    private int[] getToppingTypes(int pizzaType) {
        // selectedToppings is an array of 0-based indices
        int selectedToppings[];

        if (isCustomPizza(pizzaType)) {
            selectedToppings = new int[0];

            while (true) {
                clearScreen();
                printItemPriceList("Toppings", TOPPING_LIST[pizzaType], new String[0],
                        PRICE_VARIATION_TOPPING[pizzaType],
                        selectedToppings);

                System.out.println("Select your preferred toppings by index.");
                System.out.println("Enter 0 to finalize selection and proceed.");

                // input is an 1-based index
                int input = readIndexInput(stdinReader);

                if (!validateIndexInput(input, 0, TOPPING_LIST[pizzaType].length))
                    continue;
                else if (input == 0)
                    break;

                int inputInSelectedToppings = linearSearchInt(selectedToppings, input - 1);

                if (indexToBool(inputInSelectedToppings)) {
                    deleteElement(selectedToppings, inputInSelectedToppings);
                } else {
                    if (!isVeggie(input - 1, TOPPING_IS_VEGGIE[pizzaType]))
                        if (!confirmNonVeggieSelection())
                            continue;

                    selectedToppings = appendElement(selectedToppings, input - 1);
                }
            }
        } else {
            selectedToppings = new int[TOPPING_LIST[pizzaType].length];
            for (int i = 0; i < selectedToppings.length; ++i)
                selectedToppings[i] = i;

            clearScreen();
            printItemPriceList("Toppings", TOPPING_LIST[pizzaType], new String[0], PRICE_VARIATION_TOPPING[pizzaType],
                    selectedToppings);

            System.out.println(
                    "These are the toppings from the pizza you selected. You will not be able to change the selections. If you want to do so, order a Custom pizza instead.");
            System.out.println("Press enter to proceed.");

            readLine(stdinReader);
        }

        return selectedToppings;
    }
}
