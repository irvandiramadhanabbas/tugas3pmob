package com.example.form

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

// Data model untuk teman
data class Friend(
    val photoResId: Int,  // ID dari gambar di drawable
    val name: String,
    val email: String,
    val address: String
)

// Fungsi untuk mendapatkan daftar teman
@Composable
fun getFriends(): List<Friend> {
    val photoResIds = listOf(
        R.drawable.friend1, R.drawable.friend2, R.drawable.friend3,
        R.drawable.friend4, R.drawable.friend5, R.drawable.friend6,
        R.drawable.friend7, R.drawable.friend8, R.drawable.friend9,
        R.drawable.friend10, R.drawable.friend11, R.drawable.friend12,
        R.drawable.friend13, R.drawable.friend14, R.drawable.friend15,
        R.drawable.friend16, R.drawable.friend17, R.drawable.friend18,
        R.drawable.friend19, R.drawable.friend20
    )

    val names = listOf(
        "Abid Falihaqil", "Adjie Putra Ramdhani", "Aris Fadhila", "Ela Melina", "Farhan Arfazi",
        "Hairunisha", "Irvandi Ramadhan Abbas", "Muhammad Al Ghifary Afisha", "M. Qodratul Qudus", "Nadya Halliza",
        "Naufal Affandi", "Naya Nabila", "Nisha Rahmadini Syahda", "Noval Adiya Putra", "Rafinaldi",
        "Rijan Ananta", "Rizky Syakuur Rahman", "Salsabillah Amalia Al Hadi", "Tengku Ipo Rasya Abadi", "Lukas Tombolon"
    )

    val emails = listOf(
        "Helperbid1@gmail.com", "adjieramdhani4@gmail.com", "arisfadhila@gmail.com", "elamelina7777@gmail.com", "farhanarfazi7@gmail.com",
        "hairunisha76@gmail.com", "Vandigtg99@gmail.com", "12350111885@students.uin-suska.ac.id", "mqudri2005@gmail.com", "nadyahalliza.9h@gmail.com",
        "samuelsatria@gmail.com", "nayaanabila20@gmail.com", "nishasyahda@gmail.com", "novaladiyaputra@gmail.com", "rafinaldi05@gmail.com",
        "rijanananta09@gmail.com", "rizkysyakuurrahman18@gmail.com", "Salsabillahamalia3@gmail.com", "tengkuiporasya@gmail.com", "lukastombolon99@gmail.com"
    )

    val addresses = listOf(
        "Jl Provinsi, Kartama, Marpoyan Damai", "Jl. Beringin-Air Hitam, Gg. Ar-Rahman, Sungai Sibam, Tapung", "Jl. Manunggal, Rimbo Panjang",
        "Jl. Mawar, Simpang Baru, Tampan", "Jl. Cempaka, Gg Sekuntum No. 6", "Jl. Rimbo Panjang Tambang",
        "Jl. Rimbo Panjang, Gg Asta Karya, Tambang", "Jl. Rimba Panjang, Pekanbaru-Bangkinang, Kabupaten Kampar, Riau 28468",
        "Jl. Andalas, Sidomulyo Barat, Tampan", "Jl. Ahmad Dahlan, Tambusai, Rumbio Jaya, Kampar",
        "Jl. Garuda Sakti, Jl. Satria, Kel. Simpang Baru, Tampan", "Jl. Taman Karya, Perum. Permata Bunda 1, Tampan",
        "Jalan Kruing 2 Pandau Permai", "Jl. Sukakarya, Tuah Karya, Tampan", "Jl. Melur, Sidomulyo Barat, Tampan",
        "Jl. Garuda Sakti, Jl. Satria, Kel. Simpang Baru, Tampan", "Jl. Sepakat, Garuda Sakti KM 1,5, Kel. Simpang Baru, Kec. Tampan, Riau",
        "Jl. Perumahan Vaishatamma, Jl. Anggrek No.11, RT.006/RW.016, Desa Rawang Air Putih, Kec. Tampan, Kota Pekanbaru, Riau 28293",
        "Jl. Suka Karya, Perumahan Laucih", "Jl.kenanga"
    )

    return List(20) { index ->
        Friend(
            photoResId = photoResIds[index],
            name = names[index],
            email = emails[index],
            address = addresses[index]
        )
    }
}


// Tampilan setiap item teman
@Composable
fun FriendItem(friend: Friend) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            val painter = painterResource(id = friend.photoResId)
            // Gambar teman dari drawable resource
            Image(
                painter = painterResource(id = friend.photoResId), // FIX: Gunakan gambar sesuai friend.photoResId
                contentDescription = "Friend Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(150.dp)  // Atur ukuran gambar
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colors.primary, CircleShape)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Info Teman
            Column {
                Text(text = friend.name, style = MaterialTheme.typography.h6)
                Text(text = friend.email, style = MaterialTheme.typography.body2)
                Text(text = friend.address, style = MaterialTheme.typography.body2)
            }
        }
    }
}

// Tampilan daftar teman
@Composable
fun FriendList(friends: List<Friend>) {
    LazyColumn {
        items(friends) { friend ->
            FriendItem(friend)  // Menampilkan setiap item teman
        }
    }
}

// Tampilan layar utama
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FriendListScreen() {
    val friends = getFriends()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Member Kelas C") },
                backgroundColor = MaterialTheme.colors.primary
            )
        },
        content = {
            FriendList(friends)
        }
    )
}

// Tampilan utama aplikasi
@Composable
fun MyApp() {
    MaterialTheme {
        FriendListScreen()
    }
}

// Preview untuk tampilan di Android Studio
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}
