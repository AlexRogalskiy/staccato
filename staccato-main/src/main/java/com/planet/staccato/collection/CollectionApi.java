package com.planet.staccato.collection;

import com.planet.staccato.model.Item;
import com.planet.staccato.model.ItemCollection;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

/**
 * Defines the controller interface for the STAC collection specification
 *
 * @author joshfix
 * Created on 10/15/18
 * @see <a href="https://github.com/radiantearth/stac-spec/tree/master/collection-spec">collection-spec</a>
 */
public interface CollectionApi {

    @GetMapping(value = "/collections/{collectionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<CollectionMetadata> getCollection(@PathVariable("collectionId") String collectionId);

    @GetMapping(value = "/collections/{collectionId}/items", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<ItemCollection> getCollectionItems(@PathVariable("collectionId") String collectionId,
                                            @RequestParam(value = "bbox", required = false) double[] bbox,
                                            @RequestParam(value = "time", required = false) String time,
                                            @RequestParam(value = "query", required = false) String query,
                                            @RequestParam(value = "limit", required = false) Integer limit,
                                            @RequestParam(value = "page", required = false) Integer page,
                                            @RequestParam(value = "ids", required = false) String[] ids,
                                            @RequestParam(value = "collections", required = false) String[] collections,
                                            @RequestParam(value = "propertyname", required = false) String[] propertyname,
                                            @RequestParam(value = "intersects", required = false) Object geometry);

    @GetMapping(value = "/collections/{collectionId}/items", params = "page", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<ItemCollection> getCollectionItemsScroll(@PathVariable("collectionId") String collectionId,
                                                  @RequestParam(value = "bbox", required = false) double[] bbox,
                                                  @RequestParam(value = "time", required = false) String time,
                                                  @RequestParam(value = "query", required = false) String query,
                                                  @RequestParam(value = "limit", required = false) Integer limit,
                                                  @RequestParam(value = "page", required = false) Integer page,
                                                  @RequestParam(value = "ids", required = false) String[] ids,
                                                  @RequestParam(value = "collections", required = false) String[] collections,
                                                  @RequestParam(value = "propertyname", required = false) String[] propertyname,
                                                  @RequestParam(value = "intersects", required = false) Object geometry);

    @GetMapping(value = "/collections/{collectionId}/items/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
    Mono<Item> getCollectionItems(@PathVariable("collectionId") String collectionId,
                                  @PathVariable("itemId") String itemId);

}
