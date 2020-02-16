package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Album;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.item.Movie;
import jpabook.jpashop.exception.NotEnoughStockException;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void addItems() throws Exception {
        //given
        Album album = new Album();
        Book book = new Book();
        Movie movie = new Movie();

        album.setArtist("album");
        book.setAuthor("book");
        movie.setActor("movie");
        album.addStock(1);
        book.addStock(98);
        movie.addStock(5);

        //when
        Long saveAlbumId = itemService.saveItem(album);
        Long saveBookId = itemService.saveItem(book);
        Long saveMovieId = itemService.saveItem(movie);

        //then
        assertEquals(album, itemRepository.findOne(saveAlbumId));
        assertEquals(book, itemRepository.findOne(saveBookId));
        assertEquals(movie, itemRepository.findOne(saveMovieId));
    }

    @Test(expected = NotEnoughStockException.class)
    public void addItemException() throws Exception {
        //given
        Album album = new Album();

        album.setArtist("album");
        album.addStock(-201);


        //when
        itemService.saveItem(album);

        //then
        fail("Must be failure");
    }
}