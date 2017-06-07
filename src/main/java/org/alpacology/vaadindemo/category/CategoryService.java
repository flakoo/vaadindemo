package org.alpacology.vaadindemo.category;

import com.google.common.collect.Lists;

import java.util.List;

public class CategoryService {

    private static List<Category> categories;
    static {
        categories = Lists.newArrayList(
                Category.builder()
                        .id(1)
                        .name("Development")
                        .build(),
                Category.builder()
                        .id(2)
                        .name("Meeting")
                        .build(),
                Category.builder()
                        .id(3)
                        .name("Management")
                        .build(),
                Category.builder()
                        .id(4)
                        .name("Other")
                        .build()
        );
    }

    public List<Category> getCategories() {
        return categories;
    }
}
