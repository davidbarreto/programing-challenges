use std::{cell::RefCell, rc::Rc};

struct Trie {
    root: Rc<RefCell<TrieNode>>
}

struct TrieNode {
    children: [Option<Rc<RefCell<TrieNode>>>; 26],
    is_end: bool
}

impl TrieNode {
    fn new() -> Self {
        TrieNode {
            children: [const {None}; 26],
            is_end: false
        }
    }
}


/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl Trie {

    fn new() -> Self {
        Trie {
            root: Rc::new(RefCell::new(TrieNode::new()))
        }
    }
    
    fn insert(&self, word: String) {
        
        let mut current = Rc::clone(&self.root);
        for b in word.bytes() {
            let i = (b - b'a') as usize;
            {
                let mut node = current.borrow_mut();
                if node.children[i].is_none() {
                    node.children[i] = Some(Rc::new(RefCell::new(TrieNode::new()))); // Explicitly drop the borrow before mutating
                }
            }

            let child = current.borrow().children[i].as_ref().unwrap().clone();
            current = child;
        }

        current.borrow_mut().is_end = true;
    }
    
    fn search(&self, word: String) -> bool {
        self.search_word(word, false)
    }
    
    fn starts_with(&self, prefix: String) -> bool {
        self.search_word(prefix, true)
    }

    fn search_word(&self, word: String, is_prefix: bool) -> bool {
        let mut current = Rc::clone(&self.root);

        for b in word.bytes() {
            let i = (b - b'a') as usize;
            let maybe = current.borrow().children[i].as_ref().map(Rc::clone);
            match maybe {
                Some(child) => current = child,
                None => return false,
            }
        }

        is_prefix || current.borrow().is_end
    }
}