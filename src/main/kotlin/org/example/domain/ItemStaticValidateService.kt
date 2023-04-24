package org.example.domain

import java.util.function.Function

object ItemStaticValidateService {
    @JvmStatic
    fun validateItem(function: Function<Item, Boolean>, item: Item) {
        if (!function.apply(item)) {
            throw IllegalArgumentException("item or item.name is empty")
        }
    }
}
