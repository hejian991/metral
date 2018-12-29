package org.jmotor.metral.utils

import java.util.concurrent.CountDownLatch

import org.scalatest.FunSuite

import scala.util.control.NonFatal
import scala.concurrent.duration._

/**
 * Component:
 * Description:
 * Date: 2018/11/20
 *
 * @author AI
 */
class RetryableSpec extends FunSuite {

  test("retry 3") {
    var count = 0
    val maxAttempts = 3
    try {
      Retryable.retry(() ⇒ {
        count += 1
        throw new NullPointerException
      })(maxAttempts)
    } catch {
      case NonFatal(t) ⇒
        assert(count == 4)
        assert(t.isInstanceOf[NullPointerException])
    }
  }

//  test("retry duration") {
//    val timeout = 1.seconds
//    val started = System.currentTimeMillis()
//    val latch = new CountDownLatch(3)
//    val thread = new Thread() {
//      override def run(): Unit = {
//        Retryable.retryDuration(() ⇒ {
//          latch.countDown()
//          throw new NullPointerException
//        })(timeout)
//      }
//    }
//    thread.start()
//    latch.await()
//    assert(System.currentTimeMillis() - started >= 2.seconds.toMillis)
//  }

}
