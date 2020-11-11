package repro

object TestTwoSpec extends weaver.SimpleIOSuite {
  (1 to 20).foreach { i =>
    simpleTest(s"Test Two $i") {
      expect(scala.util.Random.nextInt(25) > -1)
    }
  }
}
