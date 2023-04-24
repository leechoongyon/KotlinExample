package org.example.domain

import jakarta.persistence.*

@Entity
@Table(name = "item")
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,


    @Column(nullable = true)
    val name: String?,  // ? 는 name 필드가 값이 nullable 할 수 있다는 거임
)