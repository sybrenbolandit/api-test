package nl.sybrenbolandit.webapp.controller

import com.mongodb.MongoWriteException
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Error
import io.micronaut.http.annotation.Get
import io.micronaut.http.hateos.JsonError
import io.micronaut.validation.Validated
import io.reactivex.Maybe
import nl.sybrenbolandit.persistence.model.Product
import nl.sybrenbolandit.persistence.repository.ProductRepository
import javax.validation.constraints.NotBlank

@Validated
@Controller("/products")
class ProductController(val productRepository: ProductRepository) {

    @Get("/{barcode}")
    fun findProduct(@NotBlank barcode: String): Maybe<Product> {
        return productRepository.fetchProduct(barcode)
    }
}
