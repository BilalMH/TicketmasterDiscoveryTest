package com.bilalhaider.ticketmastertechtest.data.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class LinkModel(
    val self: GenericLinkItem,
    val attractions: List<GenericLinkItem>,
    val venues: List<GenericLinkItem>
)

@Serializable
data class GenericLinkItem(
    val href: String
)
