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

  implicit class StringBoolean(val s: String) extends AnyVal {

    // safe boolean conversion
    def toBooleanSafe: Boolean = {
      if ("true".equals(s)) {
        true
      } else {
        false
      }
    }

  }

  val slash = "/"

}
