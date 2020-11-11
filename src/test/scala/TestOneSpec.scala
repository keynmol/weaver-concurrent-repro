package repro

import cats.effect.IO
import scala.concurrent.duration._
import cats.effect.Resource
object TestOneSpec extends weaver.IOSuite {
    override type Res = Int
    override def sharedResource: Resource[IO,Res] = {
        Resource.make(IO(scala.util.Random.nextInt(500)))(_ => IO.unit)
    }

  (1 to 20).foreach { i =>
    test(s"Test One $i") { res =>
      IO.sleep(res.millis) *> expect(scala.util.Random.nextInt(25) >= 0)
    }
  }
}
