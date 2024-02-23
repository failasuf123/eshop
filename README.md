## Excercise 1 ## REFLECTION

- Clean Code
  Saya menerapkan clean code dengan memakai variabel dan class yang mudah diingat hal ini akan masuk ke Readibility, selain itu saya menggunakan penamaan yang mirip seperti misalkan untuk fitur delete terdapat nama methode delete begitu 
  juga dengan update saya namakana methode update, hal ini juga akan memberikan kemudahan untuk membaca sekaligus konsisten dari segi penamaanya, saya juga mengahpus comment yang tidak diperlukan pada code saya.
- Secure Coding
  Dalam hal ini saya belum menerapkan authentication dan authorization karena tidak menjadi requirement untuk tugas ini. jad untuk secure code memang belum diperlukan untuk tugas ini, tapi yang mungkin terdekat adalah untuk delete saya   
  menginisiasikan delete product untuk methode input dari form pada delete
---------
IMPROVE CODE
Saya membagi code saya menjadi beberapa kelas sesuai dengan template yaitu controller service repository, khusus untuk edit-product saya menambahkan file html pada template
Untuk improve segi clean code sudah saya jelaskan pad bagaian *clean code*

## EXERCISE 2 REFLECTION
Refleksi Implementasi CI/CD


1. Salah satu isu yang berhasil saya atasi adalah terkait redundansi kode yang dapat menghambat 
pemeliharaan dan pengembangan lebih lanjut. Saya memutuskan untuk mengimplementasikan fungsi-fungsi 
yang sering digunakan dalam satu modul terpisah untuk meningkatkan keterbacaan dan mengurangi redundansi.

Selain itu, saya juga menemui isu terkait keamanan yang berhasil saya perbaiki. Saya melakukan 
analisis statis terhadap kode menggunakan alat bantu tertentu dan menemukan beberapa potensi 
kerentanan keamanan. Dengan memperbarui dependensi dan mengimplementasikan praktik keamanan terbaik, 
saya berhasil memitigasi risiko yang ada.

2.Ketika melihat CI/CD workflows di GitHub, saya percaya bahwa implementasi saat ini telah 
mencapai definisi Continuous Integration (CI) dan Continuous Deployment (CD). Setiap perubahan
pada repositori diuji secara otomatis menggunakan rangkaian uji yang telah disiapkan, dan jika 
berhasil, perubahan tersebut secara otomatis diterapkan ke lingkungan produksi. Proses ini memastikan 
bahwa setiap perubahan diintegrasikan dengan baik dan dapat diterapkan tanpa gangguan. Saya juga 
telah memastikan bahwa setiap langkah dalam pipeline dijalankan secara otomatis dan dapat diulang,
memenuhi prinsip-prinsip CI/CD.

Secara keseluruhan, pengalaman mengimplementasikan CI/CD ini memberikan pemahaman yang 
lebih mendalam tentang pentingnya otomatisasi dalam siklus pengembangan perangkat lunak. 
Melalui refleksi ini, saya mengenali nilai dari identifikasi dan penyelesaian masalah kualitas 
kode serta memastikan bahwa CI/CD workflows berjalan sesuai dengan prinsip CI/CD. Semua pembelajaran 
ini tertuang dalam README.md di repositori proyek untuk referensi dan transparansi yang lebih baik.

### Excercise 3 

## Soal

# Single Responsibility Principle
Ya, code ini sudah menerapkan Single Responsibility Principle, semua method pada class memang benar benar digunakan pada class yang benar, SRP dapat kita gambarkan dimana sebuah kelas, modul, atau fungsi harus memiliki satu dan hanya satu tanggung jawab. Tanggung jawab ini harus terdefinisi dengan jelas dan mudah dipahami. SRP membantu menjaga fokus dan modularitas kode, sehingga kode lebih mudah diubah, diuji, dan dipelihara.

CarRepository Semua fungsi dalam kelas ini terkait dengan pengelolaan data mobil.
Tidak ada tanggung jawab lain yang dicampur dalam kelas ini.
Meskipun menggunakan ArrayList untuk penyimpanan data, ini merupakan implementasi detail dan tidak mempengaruhi tanggung jawab utama kelas.
CarService SRP diterapkan dengan baik: Memiliki satu tanggung jawab yang jelas:mendefinisikan operasi bisnis untuk mengelola mobil.Tidak mencampurkan tanggung jawab lain dalam interface.
CarServiceImpl Cukup baik dalam menerapkan SRP:Fokus pada satu tanggung jawab: mengimplementasikan operasi bisnis mobil dengan memanggil CarRepository dan Tidak memiliki tanggung jawab lain di luar implementasi operasi bisnis.
CarController
Penggunaan extends dalam kasus ini tidak melanggar SRP dan memiliki beberapa manfaat. class controller yang terbagi dua masing-masing controller memiliki tanggung jawab yang berbeda ProductController: Mengelola produk. CarController: Mengelola mobil.Pemisahan ini membantu menjaga fokus dan modularitas kode.


# Open Closed Principle
Ya, Code sudah menerapkan OCP, OCP dapat kita definisikan dimana program harus terbuka untuk perluasan, tetapi tertutup untuk modifikasi. Hal ini berarti kita harus dapat menambahkan fitur baru tanpa harus mengubah kode yang sudah ada. OCP meningkatkan fleksibilitas dan extensibility code, sehingga kode dapat beradaptasi dengan perubahan kebutuhan.

CarService OSP sudah diterapkan dengan baik, Didefinisikan sebagai interface, memungkinkan implementasi berbeda tanpa mengubah kode yang bergantung padanya.
CarServiceImpl Sudah menerapkan OSP Tertutup terhadap modifikasi, perubahan perilaku memerlukan implementasi baru.Implementasi baru dapat menggunakan algoritma pengurutan berbeda untuk findAll. Memisahkan logika bisnis dari detail implementasi.
CarController Penggunaan interface ProductService dan CarService memungkinkan perubahan implementasi tanpa mengubah kode klen.Hal ini meningkatkan fleksibilitas dan extensibility code

# Liskov Substitution Principle
Ya, Code sudah menerapkan LSP, LSP memberikan persyaratan dimana subkelas harus dapat menggantikan superkelasnya dalam semua konteks tanpa mengubah perilaku program yang benar. LSP membantu memastikan keamanan dan keandalan kode, sehingga kode dapat diubah dan diperluas dengan aman.

CarService & CarServiceImpl sudah menerapkan LSP,CarServiceImpl merupakan subtipe dari CarService.CarServiceImpl menggantikan CarService dalam semua konteks tanpa mengubah perilaku program yang benar. Subtitusi dimungkinkan karena CarServiceImpl mewarisi dan mengimplementasikan semua metode yang didefinisikan dalam CarService.


# Interface Segregation Principle
Ya, Sudah menerapapkan ISP, ISP menjelaskan bahwa Interface harus sekecil dan sespesifik mungkin. Interface tidak boleh berisi method yang tidak relevan dengan tanggung jawabnya. ISP membantu meningkatkan modularitas dan kohesi kode, sehingga kode lebih mudah dipahami dan dipelihara.


CarService & CarServiceImpl sudah menerapkan ISP, CarService hanya mendefinisikan metode yang terkait dengan operasi CRUD mobil. Interface ini tidak terbebani dengan fungsionalitas yang tidak relevan. Meningkatkan kohesi dan keterbacaan interface. Memungkinkan implementasi lebih kecil dan lebih terfokus.

# Dependency Inversion Principle
Ya Sudah Menerapkan DIP, DIP menjelaskan bahwa modul tingkat tinggi tidak boleh bergantung pada modul tingkat rendah. Sebaliknya, kedua modul harus bergantung pada abstraksi. DIP membantu decoupling code dan meningkatkan testability, sehingga kode lebih mudah diuji dan diubah.


CarService & CarServiceImpl sudah menerapkan DIP, CarServiceImpl tidak bergantung langsung pada implementasi CarRepository. CarServiceImpl bergantung pada abstraksi CarRepository melalui injeksi dependensi. Memungkinkan pengujian unit dengan mock CarRepository. Meningkatkan fleksibilitas dan modularitas kode.

## REFLEKSI
Penerapan Prinsip SOLID dalam Proyek Kita
1) Prinsip yang Kita Terapkan:

Dalam pengembangan proyek ini, kita menerapkan prinsip SOLID. SOLID merupakan singkatan dari lima prinsip desain perangkat lunak yang penting untuk menghasilkan kode yang bersih, modular, dan mudah dipelihara. Kelima prinsip tersebut adalah:

S (Single Responsibility Principle): Setiap kelas, modul, atau fungsi harus memiliki satu dan hanya satu tanggung jawab yang spesifik.
O (Open-Closed Principle): Perangkat lunak harus terbuka untuk perluasan fungsionalitas baru tanpa harus mengubah kode yang sudah ada.
L (Liskov Substitution Principle): Subkelas harus dapat menggantikan superkelasnya dalam semua konteks tanpa mengubah perilaku program yang benar.
I (Interface Segregation Principle): Antarmuka harus kecil dan fokus pada tanggung jawab tertentu. Hindari antarmuka yang terlalu besar dan berisi fungsi yang tidak berhubungan.
D (Dependency Inversion Principle): Modul tingkat tinggi tidak boleh bergantung pada modul tingkat rendah. Keduanya harus bergantung pada abstraksi (seperti interface).
2) Keuntungan Menerapkan Prinsip SOLID:

Penerapan prinsip SOLID menawarkan beberapa keuntungan untuk proyek kita:

Keuntungan 1: Kode lebih mudah dipahami dan dipelihara: Dengan membagi kode menjadi modul-modul yang lebih kecil dan fokus, struktur dan logika program menjadi lebih jelas. Ini memudahkan kita untuk memahami kode dan membuat perubahan tanpa risiko merusak bagian lain.
Keuntungan 2: Kode lebih fleksibel dan dapat diperluas: Prinsip SOLID mendorong penggunaan abstraksi dan decoupling antar modul. Hal ini memudahkan kita untuk menambahkan fitur baru tanpa harus mengubah banyak kode yang sudah ada.
Keuntungan 3: Kode lebih mudah diuji: Modul yang fokus pada tanggung jawab tunggal lebih mudah diuji secara independen. Ini membantu memastikan kualitas dan keandalan kode keseluruhan.
Contoh: Bayangkan kita sedang mengembangkan aplikasi e-commerce. Menggunakan prinsip SRP, kita dapat membuat kelas terpisah untuk mengelola produk, keranjang belanja, dan transaksi. Ini membuat kode lebih modular dan mudah dipahami. Prinsip OCP memungkinkan kita menambahkan fitur baru seperti kupon diskon tanpa mengubah logika keranjang belanja. Prinsip LSP memastikan bahwa subkelas produk baru dapat digunakan dengan aman di sistem pembayaran. Prinsip ISP mendorong kita membuat antarmuka terpisah untuk checkout dan manajemen produk, sehingga kode menjadi lebih jelas dan mudah diubah.

3) Kerugian Tidak Menerapkan Prinsip SOLID:

Tidak menerapkan prinsip SOLID dapat menyebabkan beberapa masalah pada proyek kita:

Masalah 1: Kode menjadi sulit dipahami dan dipelihara: Ketika kode tidak terstruktur dengan baik dan memiliki tanggung jawab yang bercampur aduk, maka akan sulit untuk memahaminya dan membuat perubahan. Hal ini dapat meningkatkan risiko bug dan membuat pengembangan memakan waktu lebih lama.
Masalah 2: Kode menjadi kurang fleksibel dan sulit diperluas: Kode yang tidak mengikuti prinsip SOLID seringkali sulit untuk diubah dan diperluas. Menambahkan fitur baru dapat berdampak pada banyak bagian kode lainnya, meningkatkan risiko bug dan regresi.
Masalah 3: Kode lebih sulit diuji: Modul yang tidak fokus pada tanggung jawab tunggal sulit diuji secara independen. Hal ini dapat membuat proses pengujian menjadi lebih kompleks dan memakan waktu, serta mengurangi kepercayaan pada kualitas kode.
Contoh: Misalkan kita memiliki aplikasi sederhana untuk mengelola daftar tugas. Tanpa prinsip SRP, kita mungkin membuat satu kelas yang menangani semua hal terkait tugas, seperti menambahkan, menghapus, dan menandai sebagai selesai. Hal ini membuat kode sulit dipahami dan diubah. Jika kita ingin menambahkan fitur baru seperti pengingat, kita harus mengubah banyak bagian kode, meningkatkan risiko bug dan regresi. Selain itu, menguji fungsionalitas tugas secara independen menjadi sulit.

Dengan menerapkan prinsip SOLID, kita dapat mengembangkan kode yang lebih bersih, modular, dan mudah dipelihara. Ini akan menghemat waktu dan tenaga kita dalam jangka panjang, serta membuat kode kita lebih siap untuk perubahan dan perbaikan di masa depan.