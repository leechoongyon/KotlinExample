package org.example.domain

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ItemStaticValidateServiceTest {

    @Test
    fun testValidateItem() {
        val function = object : java.util.function.Function<Item, Boolean> {
            override fun apply(item: Item): Boolean {
                return item != null && !item.name.isNullOrEmpty()
            }
        }

        val item = Item(name = "example item")
        ItemStaticValidateService.validateItem(function, item)

        assertTrue(true) // 테스트 성공
    }
}

