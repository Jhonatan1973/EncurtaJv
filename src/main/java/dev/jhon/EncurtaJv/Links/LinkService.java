package dev.jhon.EncurtaJv.Links;
import java.time.LocalDateTime;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class LinkService {
    
    private LinkRepository linkRepository; 

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    //Generating short link

    //TODO: REFATORAR PARA INCLUIR PARTE DA URL ORIGINAL NO NOSSO ALGORITMO DE ENCURTAMENTO
    public String gerarUrlAleatoria() {
        return RandomStringUtils.randomAlphanumeric(5, 10);
    }

    public Link encurtaUrl(String urlOriginal) {
        Link link = new Link(null);
        link.setUrlOriginal(urlOriginal);
        link.setUrlEncurtada(gerarUrlAleatoria());
        link.setUrlCriadaEm(LocalDateTime.now());
        link.setUrlQrCode("QR CODE INDIPONIVEL NO MOMENTO");
        return linkRepository.save(link);
    }

    public Link obterUrlOriginal(String urlEncurtada) {
        try {
            return linkRepository.findByUrlOriginal(urlEncurtada);

        }catch (Exception error) {
            throw new RuntimeException("Erro ao obter URL original: ",  error);
        }
    }
}