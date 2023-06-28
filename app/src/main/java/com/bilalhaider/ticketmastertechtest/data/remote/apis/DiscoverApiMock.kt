package com.bilalhaider.ticketmastertechtest.data.remote.apis

import com.bilalhaider.ticketmastertechtest.data.ServiceResult
import com.bilalhaider.ticketmastertechtest.data.remote.models.AddressModel
import com.bilalhaider.ticketmastertechtest.data.remote.models.AgeRestrictionModel
import com.bilalhaider.ticketmastertechtest.data.remote.models.CityModel
import com.bilalhaider.ticketmastertechtest.data.remote.models.ClassificationModel
import com.bilalhaider.ticketmastertechtest.data.remote.models.CountryModel
import com.bilalhaider.ticketmastertechtest.data.remote.models.DateModel
import com.bilalhaider.ticketmastertechtest.data.remote.models.DiscoverEventModel
import com.bilalhaider.ticketmastertechtest.data.remote.models.DiscoverEventsResponse
import com.bilalhaider.ticketmastertechtest.data.remote.models.EmbeddedModel
import com.bilalhaider.ticketmastertechtest.data.remote.models.EventModel
import com.bilalhaider.ticketmastertechtest.data.remote.models.GenericLinkItem
import com.bilalhaider.ticketmastertechtest.data.remote.models.GenericSegmentModel
import com.bilalhaider.ticketmastertechtest.data.remote.models.ImageModel
import com.bilalhaider.ticketmastertechtest.data.remote.models.LinkModel
import com.bilalhaider.ticketmastertechtest.data.remote.models.PriceRangeModel
import com.bilalhaider.ticketmastertechtest.data.remote.models.PublicSalesModel
import com.bilalhaider.ticketmastertechtest.data.remote.models.SaleModel
import com.bilalhaider.ticketmastertechtest.data.remote.models.StartModel
import com.bilalhaider.ticketmastertechtest.data.remote.models.StatusModel
import com.bilalhaider.ticketmastertechtest.data.remote.models.TicketLimitModel
import com.bilalhaider.ticketmastertechtest.data.remote.models.VenueModel
import com.bilalhaider.ticketmastertechtest.domain.interfaces.DiscoveryApiService

class DiscoverApiMock() : DiscoveryApiService {

    override suspend fun discoverEventBySearch(searchParams: String): ServiceResult<DiscoverEventsResponse> =
        ServiceResult.Success(mockDiscoverEventsResponse)
}

val mockImageModel = ImageModel(
    ratio = "16_9",
    url = "https://s1.ticketm.net/dam/a/b0d/7207310c-f0ac-4cb2-9d95-7391daee2b0d_RETINA_PORTRAIT_16_9.jpg",
    width = 640,
    height = 360,
    fallback = false
)

val mockSalesModel = SaleModel(
    PublicSalesModel(
        startDateTime = "2023-06-02T09:00:00Z",
        startTBD = false,
        startTBA = false,
        endDateTime = "2023-12-16T18:00:00Z"
    )
)

val mockDateModel = DateModel(
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

val mockGenericSegmentModel = GenericSegmentModel(
    id = "KZFzniwnSyZfZ7v7nJ",
    name = "Music"
)

val mockClassificationModel = ClassificationModel(
    primary = true,
    segment = mockGenericSegmentModel,
    genre = mockGenericSegmentModel,
    subGenre = mockGenericSegmentModel,
    type = mockGenericSegmentModel,
    subType = mockGenericSegmentModel,
    family = false
)

val mockPriceRangeModel = PriceRangeModel(
    type = "standard including fees",
    currency = "GBP",
    min = 40.75,
    max = 44.95
)

val mockTicketLimitModel = TicketLimitModel(
    info = "Please note: There is a ticket Limit of 6 tickets per person and per credit card on this event"
)

val mockAgeRestrictionModel = AgeRestrictionModel(
    legalAgeEnforced = false
)

val mockGenericLinkItem = GenericLinkItem(
    href = "/discovery/v2/events/G5djZ9lBR3tT2?locale=en-us"
)

val mockLinkModel = LinkModel(
    self = mockGenericLinkItem,
    attractions = listOf(mockGenericLinkItem),
    venues = listOf(mockGenericLinkItem)
)

val mockCityModel = CityModel(
    name = "London"
)

val mockCountryModel = CountryModel(
    name = "Great Britain",
    countryCode = "GB"
)

val mockAddressModel = AddressModel(
    line1 = "Arena Square"
)

val mockVenueModel = VenueModel(
    name = "OVO Arena, Wembley",
    type = "venue",
    id = "KovZ9177yOV",
    postalCode = "HA9 0AA",
    city = mockCityModel,
    country = mockCountryModel,
    address = mockAddressModel
)

val mockEmbeddedModel = EmbeddedModel(
    listOf(mockVenueModel)
)

val mockEventsResponse = listOf(
    EventModel(
        name = "Sleep Token",
        type = "event",
        id = "G5djZ9lBR3tT2",
        test = false,
        url = "https://www.ticketmaster.co.uk/sleep-token-london-16-12-2023/event/37005EBEAF4A9FCF",
        locale = "en-us",
        images = listOf(mockImageModel),
        sales = mockSalesModel,
        dates = mockDateModel,
        classifications = listOf(mockClassificationModel),
        info = "Please be advised that Wembley Arena seating is divided into bays",
        pleaseNote = "Age Restrictions: Standing: 14 and over only",
        priceRanges = listOf(mockPriceRangeModel),
        ticketLimit = mockTicketLimitModel,
        ageRestrictions = mockAgeRestrictionModel,
        links = mockLinkModel,
        venuesAndAttractions = mockEmbeddedModel
    )
)

val mockDiscoverEventsResponse = DiscoverEventsResponse(DiscoverEventModel(mockEventsResponse))