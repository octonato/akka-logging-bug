package com.example

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.ActorRef
import akka.actor.typed.ActorSystem
import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.ActorContext
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.Future
import scala.util.Failure
import scala.util.Success

object HelloAkkaTyped {

  sealed trait Message
  final case class SayHello(name: String) extends Message
  final case class ChangeGreeting(greet: String) extends Message

  def behaviorCtx(greeting: String): Behavior[Message] =
    Behaviors.setup { ctx: ActorContext[Message] =>
      Behaviors.receiveMessage {
        case SayHello(name) =>
          ctx.log.info("{} {}!", greeting, name)
          Behaviors.same
        case ChangeGreeting(greet) =>
          behaviorCtx(greet)
      }
    }

}
