package com.capstone.explorin.data.datasource

import com.capstone.explorin.domain.model.BuddiesList
import com.capstone.explorin.domain.model.Category
import com.capstone.explorin.domain.model.City
import com.capstone.explorin.domain.model.Gallery
import com.capstone.explorin.domain.model.Itinerary
import com.capstone.explorin.domain.model.Position
import com.capstone.explorin.domain.model.User

class FakeDataGenerator {
    companion object {
        fun categoryData(): List<Category> {
            return listOf(
                Category(
                    idCategory = 1,
                    iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png",
                    nameCategory = "Alam"
                ),
                Category(
                    idCategory = 2,
                    iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png",
                    nameCategory = "Sejarah"
                ),
                Category(
                    idCategory = 3,
                    iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png",
                    nameCategory = "Pantai"
                ),
                Category(
                    idCategory = 4,
                    iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png",
                    nameCategory = "Gunung"
                )
            )
        }

        fun itineraryData(): List<Itinerary> {
            return listOf(
                Itinerary(
                    id = 1,
                    name = "Candi Borobudur",
                    category = Category(
                        idCategory = 1,
                        iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png",
                        nameCategory = "Alam"
                    ),
                    image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                    description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                    location = "Yogyakarta",
                    position = Position(long = 110.204336, lat = -7.607994),
                ),
                Itinerary(
                    id = 2,
                    name = "Candi Borobudur",
                    category = Category(
                        idCategory = 1,
                        iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png",
                        nameCategory = "Alam"
                    ),
                    image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                    description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                    location = "Yogyakarta",
                    position = Position(long = 110.204336, lat = -7.607994)
                ),
                Itinerary(
                    id = 3,
                    name = "Candi Borobudur",
                    category = Category(
                        idCategory = 1,
                        iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png",
                        nameCategory = "Alam"
                    ),
                    image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                    description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                    location = "Yogyakarta",
                    position = Position(long = 110.204336, lat = -7.607994)
                ),
                Itinerary(
                    id = 4,
                    name = "Candi Borobudur",
                    category = Category(
                        idCategory = 1,
                        iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png",
                        nameCategory = "Alam"
                    ),
                    image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                    description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                    location = "Yogyakarta",
                    position = Position(long = 110.204336, lat = -7.607994)
                ),
                Itinerary(
                    id = 5,
                    name = "Candi Borobudur",
                    category = Category(
                        idCategory = 1,
                        iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png",
                        nameCategory = "Alam"
                    ),
                    image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                    description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                    location = "Yogyakarta",
                    position = Position(long = 110.204336, lat = -7.607994)
                )
            )
        }

        fun citiesData(): List<City> {
            return listOf(
                City(
                    idCity = 1,
                    imgCity = "https://discoveringsurabaya.files.wordpress.com/2015/09/landmark1.jpg",
                    nameCity = "Surabaya"
                ),
                City(
                    idCity = 2,
                    imgCity = "https://discoveringsurabaya.files.wordpress.com/2015/09/landmark1.jpg",
                    nameCity = "Surabaya"
                ),
                City(
                    idCity = 3,
                    imgCity = "https://discoveringsurabaya.files.wordpress.com/2015/09/landmark1.jpg",
                    nameCity = "Surabaya"
                ),
                City(
                    idCity = 4,
                    imgCity = "https://discoveringsurabaya.files.wordpress.com/2015/09/landmark1.jpg",
                    nameCity = "Surabaya"
                ),
            )
        }

        fun detailItinerary(id: Int): Itinerary {
            return when (id) {
                1 -> {
                    Itinerary(
                        id = 1,
                        name = "Candi Borobudur",
                        category = Category(
                            idCategory = 1,
                            iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png",
                            nameCategory = "Alam"
                        ),
                        image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                        description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                        location = "Yogyakarta",
                        position = Position(long = 110.204336, lat = -7.607994),
                        gallery = listOf(
                            Gallery(
                                id = 1,
                                image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg"
                            )
                        )
                    )
                }

                else -> {
                    Itinerary(
                        id = 10,
                        name = "Default Name",
                        category = Category(1, "", ""),
                        image = "",
                        description = "",
                        location = "",
                        position = Position()
                    )
                }
            }
        }

        fun buddiesData(): List<BuddiesList> {
            return listOf(
                BuddiesList(
                    id = 1,
                    itinerary = Itinerary(
                        id = 1,
                        name = "Candi Borobudur",
                        category = Category(
                            idCategory = 1,
                            iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png",
                            nameCategory = "Alam"
                        ),
                        image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                        description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                        location = "Yogyakarta",
                        position = Position(long = 110.204336, lat = -7.607994)
                    ),
                    buddiesDescription = "Yok join guys -2 ke bromo",
                    people = userData()
                ),
                BuddiesList(
                    id = 2,
                    itinerary = Itinerary(
                        id = 1,
                        name = "Candi Borobudur",
                        category = Category(
                            idCategory = 1,
                            iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png",
                            nameCategory = "Alam"
                        ),
                        image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg",
                        description = "Candi Buddha terbesar di dunia, terletak di Magelang, Jawa Tengah.",
                        location = "Yogyakarta",
                        position = Position(long = 110.204336, lat = -7.607994)
                    ),
                    buddiesDescription = "Yok join guys -2 ke bromo",
                    people = userData()
                )
            )
        }

        fun userData(): List<User> {
            return listOf(
                User(
                    id = 1,
                    fullName = "Budi Santoso",
                    email = "budi.santoso@example.com",
                    username = "budi88",
                    phoneNumber = "081234567890",
                    city = City(
                        idCity = 1,
                        imgCity = "https://discoveringsurabaya.files.wordpress.com/2015/09/landmark1.jpg",
                        nameCity = "Surabaya"
                    ),
                    dateOfBirth = "1990-05-15",
                    gender = "Male",
                    imgProfile = "https://wallpapercave.com/wp/wp6674486.png"
                ),
                User(
                    id = 2,
                    fullName = "Anita Wijaya",
                    email = "anita.wijaya@example.com",
                    username = "anitawijaya",
                    phoneNumber = "082345678901",
                    city = City(
                        idCity = 2,
                        imgCity = "https://discoveringsurabaya.files.wordpress.com/2015/09/landmark1.jpg",
                        nameCity = "Jakarta"
                    ),
                    dateOfBirth = "1988-10-20",
                    gender = "Female",
                    imgProfile = "https://example.com/profile/anita_wijaya.jpg"
                ),
                User(
                    id = 3,
                    fullName = "Ahmad Rahman",
                    email = "ahmad.rahman@example.com",
                    username = "ahmad90",
                    phoneNumber = "083456789012",
                    city = City(
                        idCity = 3,
                        imgCity = "https://discoveringsurabaya.files.wordpress.com/2015/09/landmark1.jpg",
                        nameCity = "Bandung"
                    ),
                    dateOfBirth = "1995-03-03",
                    gender = "Male",
                    imgProfile = "https://example.com/profile/ahmad_rahman.jpg"
                ),
                User(
                    id = 4,
                    fullName = "Dewi Kusuma",
                    email = "dewi.kusuma@example.com",
                    username = "dewikusuma",
                    phoneNumber = "084567890123",
                    city = City(
                        idCity = 4,
                        imgCity = "https://discoveringsurabaya.files.wordpress.com/2015/09/landmark1.jpg",
                        nameCity = "Yogyakarta"
                    ),
                    dateOfBirth = "1992-12-08",
                    gender = "Female",
                    imgProfile = "https://example.com/profile/dewi_kusuma.jpg"
                ),
                User(
                    id = 5,
                    fullName = "Faisal Hidayat",
                    email = "faisal.hidayat@example.com",
                    username = "faisalhidayat",
                    phoneNumber = "085678901234",
                    city = City(
                        idCity = 5,
                        imgCity = "https://discoveringsurabaya.files.wordpress.com/2015/09/landmark1.jpg",
                        nameCity = "Semarang"
                    ),
                    dateOfBirth = "1987-06-25",
                    gender = "Male",
                    imgProfile = "https://example.com/profile/faisal_hidayat.jpg"
                )
            )
        }
    }
}