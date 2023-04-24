package org.example.domain

import org.example.infrastructure.ItemRepository
import org.springframework.stereotype.Service

@Service
class ItemService(
    private val itemRepository: ItemRepository,
    private val itemValidateService: ItemValidateService
) {
    fun getItem(id: Long): ItemInfo? {
        val item = itemRepository.findById(id).orElse(null)

        itemValidateService.validateItem(item)

        val function = java.util.function.Function<Item, Boolean> { myItem ->
            myItem != null && !myItem.name.isNullOrEmpty()
        }

        ItemStaticValidateService.validateItem(
            function,
            item ?: throw IllegalArgumentException("item is null")
        )


        // let 은 람다식을 사용하고자 할 때
        return item?.let { ItemInfo(it.id!!, it.name) }
    }

    fun getItemAll(): List<ItemInfo> {
        val items = itemRepository.findAll()
        return items.map { item ->
            ItemInfo(item.id!!, item.name)
        }
    }
}