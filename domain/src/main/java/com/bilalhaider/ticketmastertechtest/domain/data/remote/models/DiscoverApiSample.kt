package com.bilalhaider.ticketmastertechtest.domain.data.remote.models

/**
 * Sample data to use with composable preview
 */

val sampleImageModel = ImageModel(
    ratio = "16_9",
    url = "https://s1.ticketm.net/dam/a/b0d/7207310c-f0ac-4cb2-9d95-7391daee2b0d_RETINA_PORTRAIT_16_9.jpg",
    width = 640,
    height = 360,
    fallback = false
)

val sampleSalesModel = SaleModel(
    PublicSalesModel(
        startDateTime = "2023-06-02T09:00:00Z",
        startTBD = false,
        startTBA = false,
        endDateTime = "2023-12-16T18:00:00Z"
    )
)

val sampleDateModel = DateModel(
    StartModel(
        localDate = "2023-12-16",
        localTime = "18:00:00",
        dateTime = "2023-12-16T18:00:00Z",
        dateTBD = false,
        dateTBA = false,
        timeTBA = false,
        noSpecificTime = false
    ),
    timezone = "Europe/London",
    StatusModel(
        code = "onsale"
    ),
    spanMultipleDays = false
)

val sampleGenericSegmentModel = GenericSegmentModel(
    id = "KZFzniwnSyZfZ7v7nJ",
    name = "Music"
)

val sampleClassificationModel = ClassificationModel(
    primary = true,
    segment = sampleGenericSegmentModel,
    genre = sampleGenericSegmentModel,
    subGenre = sampleGenericSegmentModel,
    type = sampleGenericSegmentModel,
    subType = sampleGenericSegmentModel,
    family = false
)

val samplePriceRangeModel = PriceRangeModel(
    type = "standard including fees",
    currency = "GBP",
    min = 40.75,
    max = 44.95
)

val sampleTicketLimitModel = TicketLimitModel(
    info = "Please note: There is a ticket Limit of 6 tickets per person and per credit card on this event"
)

val sampleAgeRestrictionModel = AgeRestrictionModel(
    legalAgeEnforced = false
)

val sampleGenericLinkItem = GenericLinkItem(
    href = "/discovery/v2/events/G5djZ9lBR3tT2?locale=en-us"
)

val sampleLinkModel = LinkModel(
    self = sampleGenericLinkItem,
    attractions = listOf(sampleGenericLinkItem),
    venues = listOf(sampleGenericLinkItem)
)

val sampleCityModel = CityModel(
    name = "London"
)

val sampleCountryModel = CountryModel(
    name = "Great Britain",
    countryCode = "GB"
)

val sampleAddressModel = AddressModel(
    line1 = "Arena Square"
)

val sampleVenueModel = VenueModel(
    name = "OVO Arena, Wembley",
    type = "venue",
    id = "KovZ9177yOV",
    postalCode = "HA9 0AA",
    city = sampleCityModel,
    country = sampleCountryModel,
    address = sampleAddressModel
)

val sampleEmbeddedModel = EmbeddedModel(
    listOf(sampleVenueModel)
)

val sampleEvent =
    EventModel(
        name = "Sleep Token",
        type = "event",
        id = "G5djZ9lBR3tT2",
        test = false,
        url = "https://www.ticketmaster.co.uk/sleep-token-london-16-12-2023/event/37005EBEAF4A9FCF",
        locale = "en-us",
        images = listOf(sampleImageModel),
        sales = sampleSalesModel,
        dates = sampleDateModel,
        classifications = listOf(sampleClassificationModel),
        info = "Please be advised that Wembley Arena seating is divided into bays",
        pleaseNote = "Age Restrictions: Standing: 14 and over only",
        priceRanges = listOf(samplePriceRangeModel),
        ticketLimit = sampleTicketLimitModel,
        ageRestrictions = sampleAgeRestrictionModel,
        links = sampleLinkModel,
        venuesAndAttractions = sampleEmbeddedModel
    )

val sampleEvent2 =
    EventModel(
        name = "Busted",
        type = "event",
        id = "G5djZ9lBR3tT2",
        test = false,
        url = "https://www.ticketmaster.co.uk/sleep-token-london-16-12-2023/event/37005EBEAF4A9FCF",
        locale = "en-us",
        images = listOf(sampleImageModel),
        sales = sampleSalesModel,
        dates = sampleDateModel,
        classifications = listOf(sampleClassificationModel),
        info = "Please be advised that Wembley Arena seating is divided into bays",
        pleaseNote = "Age Restrictions: Standing: 14 and over only",
        priceRanges = listOf(samplePriceRangeModel),
        ticketLimit = sampleTicketLimitModel,
        ageRestrictions = sampleAgeRestrictionModel,
        links = sampleLinkModel,
        venuesAndAttractions = sampleEmbeddedModel
    )