package com.nikita.klimkin.testTaskJarSoft.service;

import com.nikita.klimkin.testTaskJarSoft.model.Banner;
import com.nikita.klimkin.testTaskJarSoft.repository.BannerRepository;
import com.nikita.klimkin.testTaskJarSoft.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Banner get(int id) {
        return bannerRepository.getOne(id);
    }

    public List<Banner> getAll() {
        return bannerRepository.findAll();
    }
}
