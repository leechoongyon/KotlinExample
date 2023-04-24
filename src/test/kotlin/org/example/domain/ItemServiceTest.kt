package org.example.domain

import org.example.infrastructure.ItemRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.util.*

class ItemServiceTest {
    private lateinit var itemService: ItemService

    @BeforeEach
    fun setUp() {
        val itemRepository = mock(ItemRepository::class.java)
        val itemValidateService = mock(ItemValidateService::class.java)
        itemService = ItemService(itemRepository, itemValidateService)

        // Mock 데이터 설정
        val item1 = Item(1, "name1")
        val item2 = Item(2, "name2")
        val item3 = Item(3, "name3")
        val items = listOf(item1, item2, item3)

        `when`(itemRepository.findById(1)).thenReturn(Optional.of(item1))
        `when`(itemRepository.findById(2)).thenReturn(Optional.of(item2))
        `when`(itemRepository.findById(3)).thenReturn(Optional.of(item3))
        `when`(itemRepository.findAll()).thenReturn(items)
    }

    @Test
    fun `getItem - success`() {
        val item = itemService.getItem(1)

        // 검증
        assertNotNull(item)
        assertEquals(1L, item?.id)
        assertEquals("name1", item?.name)
    }

    @Test
    fun `getItem - item not found`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            itemService.getItem(4)
        }
    }
}
