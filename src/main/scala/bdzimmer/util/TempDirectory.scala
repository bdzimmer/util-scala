// Copyright (c) 2018 Ben Zimmer. All rights reserved.

package bdzimmer.util

import org.scalatest.{BeforeAndAfterAll, Suite}
import java.io.File
import java.nio.file.{Files, Paths}
// import org.apache.commons.io.FileUtils


trait TempDirectory extends BeforeAndAfterAll { self: Suite =>

  private var _tempDirectory: File = _

  def tempDirname: String = _tempDirectory.getName

  override def beforeAll(): Unit = {
    super.beforeAll()
    _tempDirectory = Files.createTempDirectory(
      Paths.get("."),
      this.getClass.getName + "-").toFile
  }

  override def afterAll(): Unit = {
    try {
      // FileUtils.deleteDirectory(_tempDirectory)
      deleteRecursive(_tempDirectory)
    } finally {
      super.afterAll()
    }
  }

  def deleteRecursive(file: File): Unit = {
    if (file.isDirectory) {
      file.listFiles.foreach(deleteRecursive)
    }
    file.delete()
  }

}