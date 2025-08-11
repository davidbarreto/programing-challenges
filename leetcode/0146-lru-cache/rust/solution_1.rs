use std::cell::RefCell;
use std::collections::HashMap;
use std::rc::{Rc, Weak};

type Link = Option<Rc<RefCell<Node>>>;

struct Node {
    key: i32,
    value: i32,
    prev: Option<Weak<RefCell<Node>>>,
    next: Link,
}

impl Node {
    fn new(key: i32, value: i32) -> Rc<RefCell<Self>> {
        Rc::new(RefCell::new(Node {
            key,
            value,
            prev: None,
            next: None,
        }))
    }
}

struct LRUCache {
    capacity: usize,
    map: HashMap<i32, Rc<RefCell<Node>>>,
    head: Link,
    tail: Link,
}

impl LRUCache {
    fn new(capacity: i32) -> Self {
        LRUCache {
            capacity: capacity as usize,
            map: HashMap::new(),
            head: None,
            tail: None,
        }
    }

    fn get(&mut self, key: i32) -> i32 {
        if let Some(node_rc) = self.map.get(&key) {
            let node = node_rc.clone();
            self.move_to_head(node.clone());
            node.borrow().value
        } else {
            -1
        }
    }

    fn put(&mut self, key: i32, value: i32) {
        if let Some(node_rc) = self.map.get(&key) {
            let node = node_rc.clone();
            node.borrow_mut().value = value;
            self.move_to_head(node);
        } else {
            let new_node = Node::new(key, value);

            if self.map.len() == self.capacity {
                // remove LRU
                if let Some(tail_node) = self.tail.take() {
                    let old_key = tail_node.borrow().key;
                    self.remove_node(tail_node.clone());
                    self.map.remove(&old_key);
                }
            }

            self.add_node(new_node.clone());
            self.map.insert(key, new_node);
        }
    }

    fn add_node(&mut self, node: Rc<RefCell<Node>>) {
        node.borrow_mut().prev = None;
        node.borrow_mut().next = self.head.clone();

        if let Some(old_head) = self.head.take() {
            old_head.borrow_mut().prev = Some(Rc::downgrade(&node));
            self.head = Some(node);
        } else {
            // first node
            self.tail = Some(node.clone());
            self.head = Some(node);
        }
    }

    fn remove_node(&mut self, node: Rc<RefCell<Node>>) {
        let mut node_borrow = node.borrow_mut();
        let prev = node_borrow.prev.take();
        let next = node_borrow.next.take();
        drop(node_borrow); // drop early to avoid borrow checker issues

        if let Some(ref prev_weak) = prev {
            if let Some(prev_node) = prev_weak.upgrade() {
                prev_node.borrow_mut().next = next.clone();
            }
        } else {
            self.head = next.clone();
        }

        if let Some(next_node) = next {
            next_node.borrow_mut().prev = prev;
        } else {
            self.tail = prev.and_then(|w| w.upgrade());
        }
    }

    fn move_to_head(&mut self, node: Rc<RefCell<Node>>) {
        self.remove_node(node.clone());
        self.add_node(node);
    }
}
