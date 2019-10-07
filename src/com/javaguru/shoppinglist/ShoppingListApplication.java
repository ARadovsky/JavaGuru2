package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        String name="";
                        do  {
                            System.out.println("Enter product name: ");
                            name = scanner.nextLine();
                            if(name.length()<3 || name.length()>32){
                                System.out.println("Length of name value must be between 3 and 32!");
                            }
                        } while(name.length()<3 || name.length()>32);
                        BigDecimal price = new BigDecimal(0);
                        do {
                            System.out.println("Enter product price: ");
                            price = new BigDecimal(scanner.nextLine());
                            if (price.compareTo(BigDecimal.valueOf(0))<=0){
                                System.out.println("Price value must be greater then 0!");
                            }
                        } while(price.compareTo(BigDecimal.valueOf(0))<=0);
                        System.out.println("Enter product category: ");
                        String category = scanner.nextLine();
                        Integer discount=0;
                        do {
                            System.out.println("Enter product discount: ");
                            discount = new Integer(scanner.nextLine());
                            if(discount>100){
                                System.out.println("Discount value must be less than 100!");
                            }
                        } while(discount>100);
                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();
                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setCategory(category);
                        product.setDiscount(discount);
                        product.setDescription(description);
                        product.setId(productIdSequence);
                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result: " + product.getId());
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult);
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}
