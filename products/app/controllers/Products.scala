package controllers

import play.api.mvc.Action
import play.api.mvc.Controller
import play.i18n.Messages
import models.Product
import play.i18n.Lang

class Products extends Controller {
  def list = Action { implicit request =>
    val products = Product.findAll
    Ok(views.html.html.products.list.render(products))
  }
}