package org.example.domain


// data 는 자동으로 equals, hashCode, toString 등의 메소드를 생성
data class ItemInfo(
    val id: Long,
    val name: String?
)