package com.padma.cartsample.controller;

import com.padma.cartsample.dto.Cartitem;
import com.padma.cartsample.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartitemController {
    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listCartitems(ModelMap model, Cartitem cartitem) {
        //model.addAttribute("cartitem", new Cartitem());
        if (cartitem == null)
            cartitem = new Cartitem();
        model.addAttribute("cartitem", cartitem);
        model.addAttribute("cartitems", cartService.findAll());
        return "cartitems";
    }

    @RequestMapping(value = "/addorupdate", method = RequestMethod.POST)
    public String addOrUpdateCartitem(@ModelAttribute("cartitem") Cartitem cartitem, BindingResult result) {
        if (cartitem.getQuantity() != 0) {
            if (cartitem.getId() != null && cartitem.getId() > 0)
                cartService.update(cartitem);
            else
                cartService.add(cartitem);
        }
        else
            cartService.remove(cartitem);
        return "redirect:/";
    }

    @RequestMapping("/load/{cartitemId}")
    public String findCartitem(@PathVariable("cartitemId") Long cartitemId, ModelMap model) {
        Cartitem cartitem = cartService.findById(cartitemId);
        model.addAttribute("cartitem", cartitem);
        model.addAttribute("cartitems", cartService.findAll());
        return "cartitems";
    }

    @RequestMapping("/delete/{cartitemId}")
    public String deleteCartitem(@PathVariable("cartitemId") Long cartitemId) {
        cartService.remove(cartService.findById(cartitemId));
        return "redirect:/";
    }

}