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

