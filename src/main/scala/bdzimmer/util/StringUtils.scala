// Copyright (c) 2015 Ben Zimmer. All rights reserved.

// Implicit classes for string extension methods.

package bdzimmer.util

object StringUtils {

  implicit class StringPath(val s: String) extends AnyVal {

    // method for joining path segments
    def /(x: String): String = {
      s + "/" + x
    }

  }

  implicit class StringConvertSafe(val s: String) extends AnyVal {

    import scala.util.Try

    // safe boolean conversion
    def toBooleanSafe: Boolean = {
      if ("true".equals(s)) {
        true
      } else {
        false
      }
    }

    // safe integer conversion
    def toIntSafe(default: Int = 0): Int = {
      Try(s.toInt).getOrElse(default)
    }

  }


  val slash = "/"

}
