package cho.mi.springcore3.itemService.domain.item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    public void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("itemA", 10000, 10);
        //when
        Item savedItem = itemRepository.save(item);
        //then
        Item findItem = itemRepository.findById(item.getId());
        assertEquals(findItem, savedItem);
    }

    @Test
    void findAll() {
        //given
        Item item1 = new Item("item1", 10000, 10);
        Item item2 = new Item("item2", 20000, 20);
        //when
        itemRepository.save(item1);
        itemRepository.save(item2);
        //then
        assertEquals(itemRepository.findAll().size(), 2);
        assertEquals(itemRepository.findAll().get(0), item1);
        assertEquals(itemRepository.findAll().get(1), item2);
    }

    @Test
    void updateItem() {
        //given
        Item item = new Item("item1", 10000, 10);
        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();
        //when
        Item updateParam = new Item("item2", 20000, 20);
        itemRepository.update(itemId, updateParam);
        //then
        Item findItem = itemRepository.findById(itemId);
        assertEquals(findItem.getItemName(), "item2");
        assertEquals(findItem.getPrice(), 20000);
        assertEquals(findItem.getQuantity(), 20);
    }

}
