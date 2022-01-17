//package com.recipeit;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class RecipeItDebug {
//    static Postgres database = new Postgres();
//    static ArrayList<Recipe> recipeDB = database.reloadRecipe();
//    static WeekDiet wd = new WeekDiet();
//
//    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//
//        while (true){
//            System.out.println("|    RECIPEIT APPLICATION    |");
//            System.out.println("|============================|");
//            System.out.println("|  1. Add Recipe             |");
//            System.out.println("|  2. Edit Recipe Quantity   |");
//            System.out.println("|  3. Remove Selected Recipe |");
//            System.out.println("|  4. See ShopList           |");
//            System.out.println("|  5. Add Recipe Database    |");
//            System.out.println();
//            int option = scan.nextInt();
//            System.out.print("\n");
//
//            switch (option){
//                case 1:
//                    System.out.println("These are the list of available recipe:");
//                    for (Recipe r : recipeDB){
//                        System.out.println(r.getName());
//                    }
//                    System.out.println();
//
//                    System.out.println("What is the recipe you want to add:");
//                    String recipe = scan.next();
//                    System.out.print("\n");
//                    System.out.println("How many the quantities of the recipe:");
//                    int sum = scan.nextInt();
//                    System.out.print("\n");
//                    wd.addRecipe(recipe, sum, recipeDB);
//                    break;
//                case 2:
//                    for (Recipe r : wd.recipeList){
//                        System.out.println(r.getName() + " " + r.getPortion());
//                    }
//                    System.out.println();
//                    System.out.println("Type the recipe name you would like to edit its quantity:");
//                    String option2 = scan.next();
//                    System.out.println();
//                    System.out.println("How would you like to change its portion? (e.g 1,2, etc)");
//                    int option3 = scan.nextInt();
//                    System.out.println();
//                    wd.editRecipeQuantity(option2, option3);
//                    break;
//                case 3:
//                    for (Recipe r : wd.recipeList){
//                        System.out.println(r.getName() + " " + r.getPortion());
//                    }
//                    System.out.println();
//                    System.out.println("Type the recipe name you would like to remove from the list:");
//                    String option4 = scan.next();
//                    System.out.println();
//                    wd.removeRecipe(option4);
//                    System.out.println("The recipe has been removed!");
//                    break;
//                case 4:
//                    for (Ingredient i : wd.getReqIng()){
//                        System.out.print(i.getName() + "  ");
//                        if (i.getType()==Ingredient.Type.GR){
//                            System.out.println(String.format("%.0f", i.getAmount()) + "  " + "gr");
//                        }
//                        else if (i.getType()==Ingredient.Type.ML) {
//                            System.out.println(String.format("%.0f", i.getAmount()) + "  " + "ml");
//                        }
//                        else if (i.getType()==Ingredient.Type.O){
//                            System.out.println(String.format("%.0f", i.getAmount()) + "  " + "Buah");
//                        }
//                        else if (i.getType()== Ingredient.Type.SDT){
//                            System.out.println(i.getAmount() + " " + "sdt");
//                        }
//                        else if (i.getType()==Ingredient.Type.SDM){
//                            System.out.println(i.getAmount() + " " + "sdm");
//                        }
//                    }
//                    System.out.println();
//                    System.out.println("Enter anything to go back to menu:");
//                    scan.next();
//                    break;
//                case 5:
//                    System.out.println("These are the list of available recipe:");
//                    for (Recipe r : recipeDB){
//                        System.out.println(r.getName());
//                    }
//                    System.out.println();
//                    System.out.println("What is the recipe name you would add into the database?");
//                    String option5 = scan.next();
//                    System.out.println();
//                    String i = "0";
//                    while(!i.equals("1")){
//                        String option6;
//                        System.out.println("Type the ingredient name you would like to add:");
//                        option6 = scan.next();
//                        System.out.println("Type the amount of that ingredient you would like to add to the recipe:");
//                        float option7 = scan.nextFloat();
//                        System.out.println("What is the type of the unit? ('gr', 'ml', 'sdt', 'sdm', 'buah'");
//                        String option8 = scan.next();
//                        database.uploadRecipeIng(option5, option6, option7, option8);
//                        System.out.println("Is that it? type '1' if you're done");
//                        i = scan.next();
//                    }
//                    break;
//                default:
//                    break;
//            }
//        }
//    }
//}
//
//
//
