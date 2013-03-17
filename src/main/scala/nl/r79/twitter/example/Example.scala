package nl.r79.twitter.example

import scalaz._
import Scalaz._

object Example {


  def main(args: Array[String]) {

    val nel = NonEmptyList(1, 0, 3)

    val tailWeight: NonEmptyList[Int] => String = (l: NonEmptyList[Int]) => { "Weight = " |+| l.foldr( 0 )( _ + _ ).toString }

    def apply[M[_], A, B](value:M[A], f: M[A] => B)(implicit w: Comonad[M]): M[B] = w.fmap(w.cojoin(value),f)

    println(apply(nel, tailWeight)) // NonEmptyList(Weight = 4, Weight = 3, Weight = 3)

  }


}
