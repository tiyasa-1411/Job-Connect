package com.jobconnect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobconnect.entity.Profile;
import com.jobconnect.repository.ProfileRepository;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Optional<Profile> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile updateProfile(Long id, Profile profileDetails) {
        return profileRepository.findById(id).map(profile -> {
            profile.setBio(profileDetails.getBio());
            profile.setSkills(profileDetails.getSkills());
            profile.setExperience(profileDetails.getExperience());
            return profileRepository.save(profile);
        }).orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}

