package com.nikita.klimkin.testTaskJarSoft.service;

import com.nikita.klimkin.testTaskJarSoft.model.Banner;
import com.nikita.klimkin.testTaskJarSoft.repository.BannerRepository;
import com.nikita.klimkin.testTaskJarSoft.util.BannerUtil;
import com.nikita.klimkin.testTaskJarSoft.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BannerService {

    private BannerRepository bannerRepository;

    @Autowired
    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    public Banner create(Banner banner) {
        ValidationUtil.isNew(banner);
        return bannerRepository.save(banner);
    }

    public void update(Banner banner) {
        ValidationUtil.isUpdated(banner);
        bannerRepository.save(banner);
    }

    public boolean delete(int id) {
        return bannerRepository.delete(id) != 0;
    }

    public Banner getById(int id) {
        return bannerRepository.getOne(id);
    }

    public Banner getForUser(String requestNameOfCategory) {
        List<Banner> bannersByCategory = bannerRepository.findBannersByCategoryOrderByPrice(requestNameOfCategory);
        if (bannersByCategory.isEmpty()) {
            throw new IllegalArgumentException("this request name = " + requestNameOfCategory + "doesnt exist");
        }
        double maxPriseOfBanners = bannersByCategory.get(0).getPrice();
        List<Banner> bestBanners = bannersByCategory.stream().filter((banner) -> banner.getPrice() == maxPriseOfBanners)
                .collect(Collectors.toList());
        return bestBanners.get(BannerUtil.getRandomIndexOfList(bestBanners.size()));
    }

    public List<Banner> getAll() {
        return bannerRepository.findAll();
    }

    public List<Banner> getAllForUI() { return bannerRepository.findAllByDeleted(false);}
}
