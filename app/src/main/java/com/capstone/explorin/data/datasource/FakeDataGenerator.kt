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
                    location = "Magelang",
                    position = Position(long = 110.204336, lat = -7.607994),
                ),
                Itinerary(
                    id = 2,
                    name = "Weh Island",
                    category = Category(
                        idCategory = 2,
                        iconCategory = "https://static-00.iconduck.com/assets.00/beach-icon-512x441-ow4q6h9s.png",
                        nameCategory = "Pantai"
                    ),
                    image = "https://okuselatan.disway.id/upload/35a83374bdf1245f05b6bde5085ac7ba.jpg",
                    description = "Pulau Weh adalah tempat unik di Indonesia yang dihuni oleh penduduk asli dengan budaya campuran dan umat Islam yang taat. Pulau ini memiliki beberapa tempat menyelam paling terkenal di dunia, seperti Batee Tokong dan Kepulauan Sipadan.",
                    location = "Aceh",
                    position = Position(long = 3.066667, lat = -1.833333)
                ),
                Itinerary(
                    id = 3,
                    name = "Tangkahan",
                    category = Category(
                        idCategory = 1,
                        iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png",
                        nameCategory = "Alam"
                    ),
                    image = "https://pelitabaru.com/wp-content/uploads/2021/08/tangkahan.jpg",
                    description = "Tangkahan adalah surga tersembunyi di Sumatera Utara, di mana Anda bisa bersentuhan langsung dengan gajah Sumatera. Anda dapat berinteraksi dengan mereka, memandikan mereka, menyentuh mereka, dan memberi mereka makan.",
                    location = "Sumatera Utara",
                    position = Position(long = 4.666667, lat = -0.833333)
                ),
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
                    imgCity = "https://images.solopos.com/2021/04/kota-magelang.jpg",
                    nameCity = "Magelang"
                ),
                City(
                    idCity = 3,
                    imgCity = "https://getlost.id/wp-content/uploads/2022/01/Baiturrahman_1303539688.jpg",
                    nameCity = "Aceh"
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
                        location = "Magelang",
                        position = Position(long = 110.204336, lat = -7.607994),
                        gallery = listOf(
                            Gallery(
                                id = 1,
                                image = "https://backoffice.konstruksiindo.id/images/posts/large/1689666990_bb8391f730ba479baf81.jpeg"
                            )
                        )
                    )
                }
                2 -> {
                    Itinerary(
                        id = 2,
                        name = "Weh Island",
                        category = Category(
                            idCategory = 2,
                            iconCategory = "https://static-00.iconduck.com/assets.00/beach-icon-512x441-ow4q6h9s.png",
                            nameCategory = "Pantai"
                        ),
                        image = "https://okuselatan.disway.id/upload/35a83374bdf1245f05b6bde5085ac7ba.jpg",
                        description = "Pulau Weh adalah tempat unik di Indonesia yang dihuni oleh penduduk asli dengan budaya campuran dan umat Islam yang taat. Pulau ini memiliki beberapa tempat menyelam paling terkenal di dunia, seperti Batee Tokong dan Kepulauan Sipadan.",
                        location = "Aceh",
                        position = Position(long = 3.066667, lat = -1.833333)
                    )
                }
                3 -> {
                    Itinerary(
                        id = 3,
                        name = "Tangkahan",
                        category = Category(
                            idCategory = 1,
                            iconCategory = "https://cdn.icon-icons.com/icons2/1894/PNG/512/iconfinder-tempaltaaaeas-3305213_120860.png",
                            nameCategory = "Alam"
                        ),
                        image = "https://pelitabaru.com/wp-content/uploads/2021/08/tangkahan.jpg",
                        description = "Tangkahan adalah surga tersembunyi di Sumatera Utara, di mana Anda bisa bersentuhan langsung dengan gajah Sumatera. Anda dapat berinteraksi dengan mereka, memandikan mereka, menyentuh mereka, dan memberi mereka makan.",
                        location = "Sumatera Utara",
                        position = Position(long = 113.890198, lat = -1.560745)
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
                        location = "Magelang",
                        position = Position(long = 110.204336, lat = -7.607994)
                    ),
                    buddiesTitle = "Yok join guys -2 ke borobudur",
                    buddiesDescription = "Kita masih -2 orang lagi nih guys, ke borobudur terus nginep daerah sekitaran sana untuk 3d2n ",
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
                        location = "Magelang",
                        position = Position(long = 110.204336, lat = -7.607994)
                    ),
                    buddiesTitle = "Yok join guys -2 ke borobudur",
                    buddiesDescription = "Kita masih -2 orang lagi nih guys, ke borobudur terus nginep daerah sekitaran sana untuk 3d2n ",
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
                    imgProfile = "https://akcdn.detik.net.id/visual/2019/01/29/b47f28f1-52e8-47c7-bfee-1c1e7e3168fb_43.jpeg?w=360&q=90"
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
                    imgProfile = "https://static.promediateknologi.id/crop/0x0:0x0/750x500/webp/photo/p1/294/2023/08/21/valak2-3913459072.jpg"
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
                        nameCity = "Magelang"
                    ),
                    dateOfBirth = "1992-12-08",
                    gender = "Female",
                    imgProfile = "https://www.youngontop.com/wp-content/uploads/2023/11/D2.jpg"
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
                    imgProfile = "https://media.suara.com/pictures/653x366/2023/11/28/94367-kontroversi-satria-mahathir.webp"
                )
            )
        }

        fun detailBuddies(id: Int): BuddiesList {
            return when (id) {
                1 -> {
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
                            location = "Magelang",
                            position = Position(long = 110.204336, lat = -7.607994)
                        ),
                        buddiesTitle = "Yok join guys -2 ke borobudur",
                        buddiesDescription = "Kita masih -2 orang lagi nih guys, ke borobudur terus nginep daerah sekitaran sana untuk 3d2n ",
                        people = userData()
                    )
                }

                else -> {
                    BuddiesList(
                        id = 10,
                        itinerary = Itinerary(
                            id = 10,
                            name = "",
                            category = Category(
                                idCategory = 10,
                                iconCategory = "",
                                nameCategory = ""
                            ),
                            image = "",
                            description = "",
                            location = "",
                            position = Position(long = 110.204336, lat = -7.607994)
                        ),
                        buddiesTitle = "",
                        buddiesDescription = "",
                        people = userData()
                    )
                }
            }
        }
    }
}