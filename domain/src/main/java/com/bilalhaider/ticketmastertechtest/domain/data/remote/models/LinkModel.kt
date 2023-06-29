package com.bilalhaider.ticketmastertechtest.domain.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class LinkModel(
    val self: GenericLinkItem,
    val attractions: List<GenericLinkItem>? = emptyList(),
    val venues: List<GenericLinkItem>? = emptyList()
)

@Serializable
data class GenericLinkItem(
    val href: String
)
