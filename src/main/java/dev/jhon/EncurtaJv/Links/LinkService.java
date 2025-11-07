package dev.jhon.EncurtaJv.Links;
import java.time.LocalDateTime;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
@Service
public class LinkService {

    private LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String gerarUrlAleatoria() {
        return RandomStringUtils.randomAlphanumeric(5);
    }

    public Link encurtaUrl(String urlOriginal) {
        Link link = new Link();
        link.setUrlOriginal(urlOriginal);
        link.setUrlEncurtada(gerarUrlAleatoria());
        link.setUrlCriadaEm(LocalDateTime.now());
        link.setUrlQrCode("QR CODE INDISPONIVEL NO MOMENTO");
        return linkRepository.save(link);
    }

    public Link obterUrlOriginal(String urlOriginal) {
        return linkRepository.findByUrlOriginal(urlOriginal);
    }
}
