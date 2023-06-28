package com.bilalhaider.ticketmastertechtest.data.remote.api.creators

/**
 * Simulated a successful [DiscoverEventResponse]
* */

const val discoverEventSuccessJSON = """
 {
  "_embedded": {
    "events": [
      {
        "name": "Sleep Token",
        "type": "event",
        "id": "G5djZ9lBR3tT2",
        "test": false,
        "url": "https://www.ticketmaster.co.uk/sleep-token-london-16-12-2023/event/37005EBEAF4A9FCF",
        "locale": "en-us",
        "images": [
          {
            "ratio": "16_9",
            "url": "https://s1.ticketm.net/dam/a/b0d/7207310c-f0ac-4cb2-9d95-7391daee2b0d_RETINA_PORTRAIT_16_9.jpg",
            "width": 640,
            "height": 360,
            "fallback": false
          }
        ],
        "sales": {
          "public": {
            "startDateTime": "2023-06-02T09:00:00Z",
            "startTBD": false,
            "startTBA": false,
            "endDateTime": "2023-12-16T18:00:00Z"
          }
        },
        "dates": {
          "start": {
            "localDate": "2023-12-16",
            "localTime": "18:00:00",
            "dateTime": "2023-12-16T18:00:00Z",
            "dateTBD": false,
            "dateTBA": false,
            "timeTBA": false,
            "noSpecificTime": false
          },
          "timezone": "Europe/London",
          "status": {
            "code": "onsale"
          },
          "spanMultipleDays": false
        },
        "classifications": [
          {
            "primary": true,
            "segment": {
              "id": "KZFzniwnSyZfZ7v7nJ",
              "name": "Music"
            },
            "genre": {
              "id": "KnvZfZ7vAeA",
              "name": "Rock"
            },
            "subGenre": {
              "id": "KZazBEonSMnZfZ7v6dt",
              "name": "Alternative Rock"
            },
            "type": {
              "id": "KZAyXgnZfZ7v7nI",
              "name": "Undefined"
            },
            "subType": {
              "id": "KZFzBErXgnZfZ7v7lJ",
              "name": "Undefined"
            },
            "family": false
          }
        ],
        "info": "Please be advised that Wembley Arena seating is divided into bays: - Blocks A and B are not raked and other customers may stand during the performance. - Blocks C and D are tiered behind these. - Block E represents the East Terrace. Higher rows may not be suitable for patrons who cannot manage steps or who are unhappy with heights. - Blocks N and S are within the tiered, side seating of the Arena. Even numbered bays (i.e. N6) are in the lower tier; odd numbered bays (i.e. N7) will be in the upper tier. Upper Tier seats are not suitable for those who cannot manage steps and the higher rows are not suitable for those who are unhappy with heights Please ensure the seats are appropriate for you.",
        "pleaseNote": "Age Restrictions: Standing: 14 and over only. 14-15 year olds to be accompanied by an adult (16+) Seated: Under 14s to be accompanied by an adult A max of 6 tickets per person and per household applies. Tickets in excess of 6 will be cancelled.",
        "priceRanges": [
          {
            "type": "standard including fees",
            "currency": "GBP",
            "min": 40.75,
            "max": 44.95
          },
          {
            "type": "standard",
            "currency": "GBP",
            "min": 35,
            "max": 38.5
          }
        ],
        "ticketLimit": {
          "info": "Please note: There is a ticket Limit of 6 tickets per person and per credit card on this event"
        },
        "ageRestrictions": {
          "legalAgeEnforced": false
        },
        "_links": {
          "self": {
            "href": "/discovery/v2/events/G5djZ9lBR3tT2?locale=en-us"
          },
          "attractions": [
            {
              "href": "/discovery/v2/attractions/K8vZ917b81f?locale=en-us"
            }
          ],
          "venues": [
            {
              "href": "/discovery/v2/venues/KovZ9177yOV?locale=en-de"
            }
          ]
        },
        "_embedded": {
          "venues": [
            {
              "name": "OVO Arena, Wembley",
              "type": "venue",
              "id": "KovZ9177yOV",
              "postalCode": "HA9 0AA",
              "city": {
                "name": "London"
              },
              "country": {
                "name": "Great Britain",
                "countryCode": "GB"
              },
              "address": {
                "line1": "Arena Square",
                "line2": "Wembley"
              }
            }
          ]
        }
      },
      {
        "name": "Leeds Festival 2023 - Weekend",
        "type": "event",
        "id": "G5dfZ98Nduo-7",
        "test": false,
        "url": "https://www.ticketmaster.co.uk/leeds-festival-2023-weekend-leeds-24-08-2023/event/35005D08C3351844",
        "locale": "en-us",
        "images": [
          {
            "ratio": "16_9",
            "url": "https://s1.ticketm.net/dam/a/58b/2fad5c42-0a76-4eee-9765-469e28d0258b_495841_RECOMENDATION_16_9.jpg",
            "width": 100,
            "height": 56,
            "fallback": false
          }
        ],
        "sales": {
          "public": {
            "startDateTime": "2022-12-12T09:00:00Z",
            "startTBD": false,
            "startTBA": false,
            "endDateTime": "2023-08-27T22:59:00Z"
          }
        },
        "dates": {
          "start": {
            "localDate": "2023-08-24",
            "dateTBD": false,
            "dateTBA": false,
            "timeTBA": false,
            "noSpecificTime": true
          },
          "end": {
            "localDate": "2023-08-27",
            "approximate": false,
            "noSpecificTime": true
          },
          "timezone": "Europe/London",
          "status": {
            "code": "onsale"
          },
          "spanMultipleDays": false
        },
        "classifications": [
          {
            "primary": true,
            "segment": {
              "id": "KZFzniwnSyZfZ7v7nJ",
              "name": "Music"
            },
            "genre": {
              "id": "KnvZfZ7vAe6",
              "name": "Undefined"
            },
            "subGenre": {
              "id": "KZazBEonSMnZfZ7v6JI",
              "name": "Undefined"
            },
            "type": {
              "id": "KZAyXgnZfZ7v7lt",
              "name": "Event Style"
            },
            "subType": {
              "id": "KZFzBErXgnZfZ7vA6E",
              "name": "Festival"
            },
            "family": false
          }
        ],
        "info": "All under 16s must be accompanied by an adult ticket holder aged 18 or over who must remain on site throughout the weekend as the under 16-year-old's guardian. No unaccompanied under 16s are allowed on site. Under 13's (12 years and under) are admitted free but must be accompanied by a paying ticket-holder over 18 at all times. Wristbands, to write a mobile number on for children 12 and under in case they get lost or separated from their guardian, will be available from the wristband exchanges & welfare points. We do not accept any parental or supervisory duty of care or liability for any under 18s on site. If you want to arrive before 8am on Thursday 24/08/23 you must purchase a \"Weekend Ticket Plus Early Entry Pass 2023\" If you want to arrive after 8am on Thursday 24/08/23 you are OK to purchase a \"Weekend Ticket",
        "pleaseNote": "No unaccompanied under 16s allowed on site. Under 13s (12yrs and under) are admitted free, but must be accompanied by a paying ticket holder (18+) at all times. There is a ticket limit of 4 tickets per person/per address/per credit card on this event. Please adhere to published ticket limits. Persons who exceed the ticket limit may have any or all of their order(s) and tickets cancelled without prior notice by Ticketmaster in its discretion. This includes: orders associated with the same name, e-mail address, billing address, credit card number or other information.",
        "priceRanges": [
          {
            "type": "standard",
            "currency": "GBP",
            "min": 265,
            "max": 265
          },
          {
            "type": "standard including fees",
            "currency": "GBP",
            "min": 265,
            "max": 286.2
          }
        ],
        "ageRestrictions": {
          "legalAgeEnforced": false
        },
        "_links": {
          "self": {
            "href": "/discovery/v2/events/G5dfZ98Nduo-7?locale=en-us"
          },
          "attractions": [
            {
              "href": "/discovery/v2/attractions/K8vZ917GkJ0?locale=en-us"
            }
          ],
          "venues": [
            {
              "href": "/discovery/v2/venues/KovZ9177JYV?locale=en-de"
            }
          ]
        },
        "_embedded": {
          "venues": [
            {
              "name": "Bramham Park",
              "type": "venue",
              "id": "KovZ9177JYV",
              "postalCode": "LS23 6ND",
              "city": {
                "name": "Leeds"
              },
              "country": {
                "name": "Great Britain",
                "countryCode": "GB"
              },
              "address": {
                "line1": "Wetherby"
              }
            }
          ]
        }
      }
    ]
  }
}
"""