package com.mistpaag.requestmanager.base

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection


internal class MovieDispatcher : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            "/movie/popular?page=1" -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(response)
            }
            else -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody("[]")
            }
        }
    }

}

private val response = "{\n" +
        "    \"page\": 18,\n" +
        "    \"results\": [\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/msU3F9DVNFvCsQVxhxliyWSO03D.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                28,\n" +
        "                12,\n" +
        "                14\n" +
        "            ],\n" +
        "            \"id\": 10196,\n" +
        "            \"original_language\": \"en\",\n" +
        "            \"original_title\": \"The Last Airbender\",\n" +
        "            \"overview\": \"The story follows the adventures of Aang, a young successor to a long line of Avatars, who must put his childhood ways aside and stop the Fire Nation from enslaving the Water, Earth and Air nations.\",\n" +
        "            \"popularity\": 128.908,\n" +
        "            \"poster_path\": \"/zgwRTYWEEPivTwjB9S03HtmMcbM.jpg\",\n" +
        "            \"release_date\": \"2010-06-30\",\n" +
        "            \"title\": \"The Last Airbender\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 4.7,\n" +
        "            \"vote_count\": 3128\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/l5yp73psXVRYy2ce09lD8yDuu2g.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                27,\n" +
        "                53\n" +
        "            ],\n" +
        "            \"id\": 138843,\n" +
        "            \"original_language\": \"en\",\n" +
        "            \"original_title\": \"The Conjuring\",\n" +
        "            \"overview\": \"Paranormal investigators Ed and Lorraine Warren work to help a family terrorized by a dark presence in their farmhouse. Forced to confront a powerful entity, the Warrens find themselves caught in the most terrifying case of their lives.\",\n" +
        "            \"popularity\": 128.223,\n" +
        "            \"poster_path\": \"/wVYREutTvI2tmxr6ujrHT704wGF.jpg\",\n" +
        "            \"release_date\": \"2013-03-20\",\n" +
        "            \"title\": \"The Conjuring\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 7.5,\n" +
        "            \"vote_count\": 8944\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/piz0BFUJ4Bro4BFzxxkNpsGCmOd.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                14,\n" +
        "                10751\n" +
        "            ],\n" +
        "            \"id\": 739990,\n" +
        "            \"original_language\": \"en\",\n" +
        "            \"original_title\": \"Nightbooks\",\n" +
        "            \"overview\": \"Alex, a boy obsessed with scary stories, is trapped by a witch in her modern, magical New York City apartment. His original hair-raising tales are the only thing keeping him safe as he desperately tries to find a way out of this twisted place.\",\n" +
        "            \"popularity\": 127.682,\n" +
        "            \"poster_path\": \"/ysJte1iqN8pFQ470tumnViB1wHP.jpg\",\n" +
        "            \"release_date\": \"2021-09-15\",\n" +
        "            \"title\": \"Nightbooks\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 6.5,\n" +
        "            \"vote_count\": 204\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/hVxPPgSL72qS18jIB3eWXoAsoWu.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                16,\n" +
        "                35,\n" +
        "                10751\n" +
        "            ],\n" +
        "            \"id\": 585,\n" +
        "            \"original_language\": \"en\",\n" +
        "            \"original_title\": \"Monsters, Inc.\",\n" +
        "            \"overview\": \"James Sullivan and Mike Wazowski are monsters, they earn their living scaring children and are the best in the business... even though they're more afraid of the children than they are of them. When a child accidentally enters their world, James and Mike suddenly find that kids are not to be afraid of and they uncover a conspiracy that could threaten all children across the world.\",\n" +
        "            \"popularity\": 127.605,\n" +
        "            \"poster_path\": \"/sgheSKxZkttIe8ONsf2sWXPgip3.jpg\",\n" +
        "            \"release_date\": \"2001-11-01\",\n" +
        "            \"title\": \"Monsters, Inc.\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 7.8,\n" +
        "            \"vote_count\": 14947\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/mEDMV7gA36wJYYx2VcywF2DWCg1.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                35\n" +
        "            ],\n" +
        "            \"id\": 57214,\n" +
        "            \"original_language\": \"en\",\n" +
        "            \"original_title\": \"Project X\",\n" +
        "            \"overview\": \"Three high school seniors throw a party to make a name for themselves. As the night progresses, things spiral out of control as word of the party spreads.\",\n" +
        "            \"popularity\": 127.592,\n" +
        "            \"poster_path\": \"/lUPDGT3lyRrq8SvWuNWG2DP64bR.jpg\",\n" +
        "            \"release_date\": \"2012-03-01\",\n" +
        "            \"title\": \"Project X\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 6.8,\n" +
        "            \"vote_count\": 4905\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/yO2LFaO62SoM1ZuOq26hWLF1TQ4.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                27,\n" +
        "                53,\n" +
        "                9648\n" +
        "            ],\n" +
        "            \"id\": 740925,\n" +
        "            \"original_language\": \"en\",\n" +
        "            \"original_title\": \"No One Gets Out Alive\",\n" +
        "            \"overview\": \"An immigrant in search of the American dream is forced to take a room in a boarding house and soon finds herself in a nightmare from which she can't escape.\",\n" +
        "            \"popularity\": 127.43,\n" +
        "            \"poster_path\": \"/bZUostLcCZYgcuBuAjmuSkBggiQ.jpg\",\n" +
        "            \"release_date\": \"2021-09-29\",\n" +
        "            \"title\": \"No One Gets Out Alive\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 6,\n" +
        "            \"vote_count\": 256\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/xZiMSXA8w1T2nWlXPDjN0RAYOvQ.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                18,\n" +
        "                878\n" +
        "            ],\n" +
        "            \"id\": 866408,\n" +
        "            \"original_language\": \"zh\",\n" +
        "            \"original_title\": \"火星异变\",\n" +
        "            \"overview\": \"In the near future, the Earth’s resources are gradually getting scarce. In order to continue the hope of survival for generations of children and grandchildren, top scientists from various countries have brought several species of animals and plants to Mars for research, hoping to improve the Martian environment through advanced science and technology to make it suitable for human habitation.\",\n" +
        "            \"popularity\": 162.494,\n" +
        "            \"poster_path\": \"/h4HcBZC8XMuSFBNxWu7qd34tFDI.jpg\",\n" +
        "            \"release_date\": \"2021-08-27\",\n" +
        "            \"title\": \"Mutation on Mars\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 6.3,\n" +
        "            \"vote_count\": 19\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/vpip36rKLNonjYAZkJSPxM5RCn8.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                27,\n" +
        "                35,\n" +
        "                14\n" +
        "            ],\n" +
        "            \"id\": 287903,\n" +
        "            \"original_language\": \"en\",\n" +
        "            \"original_title\": \"Krampus\",\n" +
        "            \"overview\": \"When his dysfunctional family clashes over the holidays, young Max is disillusioned and turns his back on Christmas.  Little does he know, this lack of festive spirit has unleashed the wrath of Krampus: a demonic force of ancient evil intent on punishing non-believers.\",\n" +
        "            \"popularity\": 126.732,\n" +
        "            \"poster_path\": \"/dxnRNv9GL5tupUoVPE5lT2RdO9q.jpg\",\n" +
        "            \"release_date\": \"2015-11-26\",\n" +
        "            \"title\": \"Krampus\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 6.1,\n" +
        "            \"vote_count\": 1573\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/AX8VvTMrzEddzMa4zR2NNHUtZ9.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                53,\n" +
        "                27\n" +
        "            ],\n" +
        "            \"id\": 777620,\n" +
        "            \"original_language\": \"en\",\n" +
        "            \"original_title\": \"Caged\",\n" +
        "            \"overview\": \"An African American male is imprisoned and placed in solitary confinement after being found guilty of murdering his wife, as he's haunted by internal demons and his dead wife, and pushed to the breaking point by an abusive female guard.\",\n" +
        "            \"popularity\": 126.542,\n" +
        "            \"poster_path\": \"/8NUM43rtQSt0chumXGJPvnYb01I.jpg\",\n" +
        "            \"release_date\": \"2021-01-26\",\n" +
        "            \"title\": \"Caged\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 6.4,\n" +
        "            \"vote_count\": 45\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/5C8bfwglg91uZhc2fbfpSjNGamV.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                27,\n" +
        "                9648\n" +
        "            ],\n" +
        "            \"id\": 591273,\n" +
        "            \"original_language\": \"en\",\n" +
        "            \"original_title\": \"Fear Street: 1994\",\n" +
        "            \"overview\": \"After a series of brutal slayings, a teen and her friends take on an evil force that's plagued their notorious town for centuries.\",\n" +
        "            \"popularity\": 126.449,\n" +
        "            \"poster_path\": \"/9J9Wy39ZjrVmfk7yMkulpcI5sy0.jpg\",\n" +
        "            \"release_date\": \"2021-06-28\",\n" +
        "            \"title\": \"Fear Street: 1994\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 6.8,\n" +
        "            \"vote_count\": 1307\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/pFnEAK3eN8xX9AeggG9ISFYr1OO.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                53\n" +
        "            ],\n" +
        "            \"id\": 835551,\n" +
        "            \"original_language\": \"en\",\n" +
        "            \"original_title\": \"Masquerade\",\n" +
        "            \"overview\": \"A young girl struggles to survive after a group of home invaders break into her house to steal her family's priceless artwork.\",\n" +
        "            \"popularity\": 172.875,\n" +
        "            \"poster_path\": \"/1sHH629kR3ZDmPfL90JkUWew4wz.jpg\",\n" +
        "            \"release_date\": \"2021-07-30\",\n" +
        "            \"title\": \"Masquerade\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 6,\n" +
        "            \"vote_count\": 43\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/6VmFqApQRyZZzmiGOQq2C92jyvH.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                18,\n" +
        "                10749\n" +
        "            ],\n" +
        "            \"id\": 597,\n" +
        "            \"original_language\": \"en\",\n" +
        "            \"original_title\": \"Titanic\",\n" +
        "            \"overview\": \"101-year-old Rose DeWitt Bukater tells the story of her life aboard the Titanic, 84 years later. A young Rose boards the ship with her mother and fiancé. Meanwhile, Jack Dawson and Fabrizio De Rossi win third-class tickets aboard the ship. Rose tells the whole story from Titanic's departure through to its death—on its first and last voyage—on April 15, 1912.\",\n" +
        "            \"popularity\": 125.073,\n" +
        "            \"poster_path\": \"/9xjZS2rlVxm8SFx8kPC3aIGCOYQ.jpg\",\n" +
        "            \"release_date\": \"1997-11-18\",\n" +
        "            \"title\": \"Titanic\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 7.9,\n" +
        "            \"vote_count\": 20238\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/vDR2h5uQNgWyx3fsEVnEOcNFibZ.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                80,\n" +
        "                53\n" +
        "            ],\n" +
        "            \"id\": 801335,\n" +
        "            \"original_language\": \"en\",\n" +
        "            \"original_title\": \"Girl in the Basement\",\n" +
        "            \"overview\": \"Sara is a teen girl who is looking forward to her 18th birthday to move away from her controlling father Don. But before she could even blow out the candles, Don imprisons her in the basement of their home.\",\n" +
        "            \"popularity\": 124.363,\n" +
        "            \"poster_path\": \"/qmddUxRwbsxHa7oEXm4PWh1KZe8.jpg\",\n" +
        "            \"release_date\": \"2021-02-27\",\n" +
        "            \"title\": \"Girl in the Basement\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 8,\n" +
        "            \"vote_count\": 284\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/jzdnhRhG0dsuYorwvSqPqqnM1cV.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                28,\n" +
        "                80,\n" +
        "                53\n" +
        "            ],\n" +
        "            \"id\": 337339,\n" +
        "            \"original_language\": \"en\",\n" +
        "            \"original_title\": \"The Fate of the Furious\",\n" +
        "            \"overview\": \"When a mysterious woman seduces Dom into the world of crime and a betrayal of those closest to him, the crew face trials that will test them as never before.\",\n" +
        "            \"popularity\": 124.218,\n" +
        "            \"poster_path\": \"/dImWM7GJqryWJO9LHa3XQ8DD5NH.jpg\",\n" +
        "            \"release_date\": \"2017-04-12\",\n" +
        "            \"title\": \"The Fate of the Furious\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 6.9,\n" +
        "            \"vote_count\": 8660\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/osHKguxvXPIUJJzsO3DEORZZ8QD.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                35,\n" +
        "                18,\n" +
        "                10749\n" +
        "            ],\n" +
        "            \"id\": 4564,\n" +
        "            \"original_language\": \"en\",\n" +
        "            \"original_title\": \"Sex and the City\",\n" +
        "            \"overview\": \"A New York writer on sex and love is finally getting married to her Mr. Big. But her three best girlfriends must console her after one of them inadvertently leads Mr. Big to jilt her.\",\n" +
        "            \"popularity\": 124.019,\n" +
        "            \"poster_path\": \"/nTiuFeutI0TD1CkXNulJlyqq5GL.jpg\",\n" +
        "            \"release_date\": \"2008-05-12\",\n" +
        "            \"title\": \"Sex and the City\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 6.6,\n" +
        "            \"vote_count\": 1726\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/tCsYQTkQx7vknDmTw666K1XxAdx.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                28,\n" +
        "                18\n" +
        "            ],\n" +
        "            \"id\": 348893,\n" +
        "            \"original_language\": \"en\",\n" +
        "            \"original_title\": \"Boyka: Undisputed IV\",\n" +
        "            \"overview\": \"In the fourth installment of the fighting franchise, Boyka is shooting for the big leagues when an accidental death in the ring makes him question everything he stands for. When he finds out the wife of the man he accidentally killed is in trouble, Boyka offers to fight in a series of impossible battles to free her from a life of servitude\",\n" +
        "            \"popularity\": 123.78,\n" +
        "            \"poster_path\": \"/7QGdIJWWTkPhVjpQ0zA6z69khod.jpg\",\n" +
        "            \"release_date\": \"2016-08-01\",\n" +
        "            \"title\": \"Boyka: Undisputed IV\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 7,\n" +
        "            \"vote_count\": 941\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/3rVeadGc32aXOtmYn3X7glSAP2r.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                35,\n" +
        "                80\n" +
        "            ],\n" +
        "            \"id\": 879163,\n" +
        "            \"original_language\": \"pt\",\n" +
        "            \"original_title\": \"Peçanha Contra o Animal\",\n" +
        "            \"overview\": \"\",\n" +
        "            \"popularity\": 149.192,\n" +
        "            \"poster_path\": \"/nH0EycssY8aFJxElTsGSRirP9qr.jpg\",\n" +
        "            \"release_date\": \"2021-10-22\",\n" +
        "            \"title\": \"Peçanha Contra o Animal\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 5.8,\n" +
        "            \"vote_count\": 21\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/ouLgfVE1ZrLEA41ZJ8Qbl5paUZX.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                10749\n" +
        "            ],\n" +
        "            \"id\": 848932,\n" +
        "            \"original_language\": \"en\",\n" +
        "            \"original_title\": \"粉色樱与大眠王\",\n" +
        "            \"overview\": \"The male lead is the king of a small island nation. He was previously badly hurt by the female lead. The female lead has a canine tooth that makes her look extremely captivating when she smiles. When the female lead vanished, the male lead became extremely fond of sleeping because he did not want to miss her. As fate would have it, the male lead married the female lead in the end. He decided to properly torment that adorable yet horrible woman for a while\",\n" +
        "            \"popularity\": 119.889,\n" +
        "            \"poster_path\": \"/xHJhH0pGTFLsECDry3G170M8fsG.jpg\",\n" +
        "            \"release_date\": \"2021-07-06\",\n" +
        "            \"title\": \"Why Women Cheat\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 4.5,\n" +
        "            \"vote_count\": 2\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/FzOdq23pNBJBW5zULFzEdjQXZD.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                80,\n" +
        "                18,\n" +
        "                35\n" +
        "            ],\n" +
        "            \"id\": 106646,\n" +
        "            \"original_language\": \"en\",\n" +
        "            \"original_title\": \"The Wolf of Wall Street\",\n" +
        "            \"overview\": \"A New York stockbroker refuses to cooperate in a large securities fraud case involving corruption on Wall Street, corporate banking world and mob infiltration. Based on Jordan Belfort's autobiography.\",\n" +
        "            \"popularity\": 122.829,\n" +
        "            \"poster_path\": \"/4O5XrcJuTIlMiDM6VO7VqPUIh1t.jpg\",\n" +
        "            \"release_date\": \"2013-12-25\",\n" +
        "            \"title\": \"The Wolf of Wall Street\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 8,\n" +
        "            \"vote_count\": 18838\n" +
        "        },\n" +
        "        {\n" +
        "            \"adult\": false,\n" +
        "            \"backdrop_path\": \"/q62bpQ67qaXY0u6b2wFEnQYIbPd.jpg\",\n" +
        "            \"genre_ids\": [\n" +
        "                10751,\n" +
        "                12,\n" +
        "                16,\n" +
        "                35,\n" +
        "                14,\n" +
        "                18\n" +
        "            ],\n" +
        "            \"id\": 301528,\n" +
        "            \"original_language\": \"en\",\n" +
        "            \"original_title\": \"Toy Story 4\",\n" +
        "            \"overview\": \"Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called \\\"Forky\\\" to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy.\",\n" +
        "            \"popularity\": 121.85,\n" +
        "            \"poster_path\": \"/w9kR8qbmQ01HwnvK4alvnQ2ca0L.jpg\",\n" +
        "            \"release_date\": \"2019-06-19\",\n" +
        "            \"title\": \"Toy Story 4\",\n" +
        "            \"video\": false,\n" +
        "            \"vote_average\": 7.6,\n" +
        "            \"vote_count\": 7585\n" +
        "        }\n" +
        "    ],\n" +
        "    \"total_pages\": 31701,\n" +
        "    \"total_results\": 634010\n" +
        "}"



