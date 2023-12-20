package com.teamjo.techeermarket.domain.mypage.controller;

import com.teamjo.techeermarket.domain.mypage.repository.UserLikeRepository;
import com.teamjo.techeermarket.domain.mypage.service.MyPageService;
import com.teamjo.techeermarket.domain.products.dto.response.ProductPreViewDto;
import com.teamjo.techeermarket.domain.products.entity.Products;
import com.teamjo.techeermarket.domain.products.repository.ProductRepository;
import com.teamjo.techeermarket.global.config.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/mypage")
public class MyPageController {

    private final  MyPageService myPageService;

//    private final ProductRepository productRepository;

    /*
    // 내가 누른 좋아요 목록 보기
    */
    @GetMapping("/like")
    public ResponseEntity<List<ProductPreViewDto>> getLikedProducts(
            @AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        String email = userDetailsImpl.getUsername();
        List<ProductPreViewDto> likedProducts = myPageService.getLikedProducts(email, pageNo, pageSize);
        return ResponseEntity.ok(likedProducts);
    }

    /*
    // 내가 구매한 상품 목록 보기
     */
    @GetMapping("/purchase")
    public ResponseEntity<List<ProductPreViewDto>> getMyPurchasedProducts(
            @AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        String email = userDetailsImpl.getUsername();
        List<ProductPreViewDto> purchasedProducts = myPageService.getMyPurchasedProducts(email, pageNo, pageSize);
        return ResponseEntity.ok(purchasedProducts);
    }


}
