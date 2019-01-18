package example

import scala.language.existentials
import scala.language.higherKinds

class TypeM {
  def m: Int = ???
}

class TypeC extends TypeM {
  val superType = super[TypeM].m
}

class TypB

class TypC

class TypP {
  class C
  class X
  val x = new X
}

class TypT {
  class C
  class X
  val x = new X
}

object TypTest {
  class M {
    def m: Int = ???
  }

  trait N {
    def n: Int = ???
  }

  class B {
    def x:Int = 4
  }

  class C extends M {
    val p = new TypP
    val x = p.x

    val typeRef1: C = ???
    val typeRef2: p.C = ???
    val typeRef3: TypT#C = ???
    val typeRef4: List[Int] = ???

    val singleType1: x.type = ???
    val singleType2: p.x.type = ???
    val Either = scala.util.Either

    val thisType1: this.type = ???
    val thisType2: C.this.type = ???

    val superType1 = super.m
    val superType2 = super[M].m
    val superType3 = C.super[M].m

    val compoundType1: { def k: Int } = ???
    val compoundType2: M with N = ???
    val compoundType3: M with N { def k: Int } = ???
    val compoundType4 = new { def k: Int = ??? }
    val compoundType5 = new M with N
    val compoundType6 = new M with N { def k: Int = ??? }

    val existentialType2: List[_] = ???
    val existentialType3 = Class.forName("foo.Bar")
    val existentialType4 = Class.forName("foo.Bar")

    def typeLambda1[M[_]] = ???
    typeLambda1[({ type L[T] = List[T] })#L]

    object ClassInfoType1
    class ClassInfoType2 extends B { override def x = 42 }
    trait ClassInfoType3[T]

    object MethodType {
      def x1: Int = ???
      def x2: Int = ???
      def m3: Int = ???
      def m4(): Int = ???
      def m5(x: Int): Int = ???
      def m6[T](x: T): T = ???
    }

    object ByNameType {
      def m1(x: => Int): Int = ???
    }

    case class RepeatedType(s: String*) {
      def m1(x: Int*): Int = s.length
    }

    object TypeType {
      type T1
      def m2[T2 >: C <: C] = ???
      def m3[M3[_]] = ???
      type T4 = C
      type T5[U] = U
    }
  }

  object Literal {
    final val int = 1
    final val long = 1L
    final val float = 1f
    final val double = 2d
    final val nil = null
    final val char = 'a'
    final val string = "a"
    final val bool = true
    final val unit = ()
    final val javaEnum = java.nio.file.LinkOption.NOFOLLOW_LINKS
    final val clazzOf = classOf[Option[Int]]
  }
}
