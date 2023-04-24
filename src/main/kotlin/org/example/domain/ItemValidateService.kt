package org.example.domain

import io.micrometer.common.util.StringUtils
import org.springframework.stereotype.Service
import org.springframework.util.ObjectUtils

@Service
class ItemValidateService {
    fun validateItem(item: Item?) {
        if (ObjectUtils.isEmpty(item) || StringUtils.isBlank(item?.name)) {
            throw IllegalArgumentException("item or item.name is empty")
        }
    }
}