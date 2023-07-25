package Tutorial6
import scala.io.StdIn

object cipher {

  val alphabet = 26
  def encrypt(text: String, shift: Int): String = {
    text.map { char =>
      if (char.isLetter) {
        val base = if (char.isUpper) 'A' else 'a'
        val encrypted = ( (char - base + shift) % alphabet + base).toChar
        encrypted
      }
      else {
        char
      }
    }
  }

  def decrypt(cipherText: String, shift: Int): String = {
    encrypt(cipherText, 26 -shift)
  }

  def cipher(text: String, shift: Int, func: (String, Int) => String): String = {
    func(text, shift)
  }


  def main(args: Array[String]): Unit = {
    print("Enter the text : ")
    val text = StdIn.readLine()

    print("Enter the number of shifts : ")
    val shift = StdIn.readInt()

    val encrypted = cipher(text, shift, encrypt)
    println("Encrypted text : " +encrypted)

    val decrypted = cipher(encrypted, shift, decrypt)
    println("Decrypted text : " + decrypted)

    }

}
