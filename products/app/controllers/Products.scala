package controllers

import play.api.mvc.Action
import play.api.mvc.Controller
import play.i18n.Messages
import models.Product
import play.i18n.Lang
import play.mvc.Http.Context

class Products extends Controller {
  def list = Action { implicit request =>
    val products = Product.findAll
    val lang = new Lang(Lang.forCode("es"))
    Ok(views.html.html.products.list.render(products, lang))
  }
  
  def show(ean: Long) = Action { implicit request =>
      Product.findByEan(ean).map { product =>
      Ok(views.html.products.details(product))
    }.getOrElse(NotFound)
  }
}