package io.red.naturassp.controller;

import io.red.naturassp.model.Categoria;
import io.red.naturassp.model.Produto;
import io.red.naturassp.service.IProdutoService;
import io.red.naturassp.service.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ProdutoController {
    @Autowired
    private IProdutoService service;
    @Autowired
    private IUploadService upload;

    @PostMapping("/produto")
    public ResponseEntity<Produto> novoProduto(@RequestBody Produto novo){
        try {
            service.inserirNovoProduto(novo);
            return ResponseEntity.status(201).body(novo);
        } catch (Exception e){
            e.getMessage();
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/produto/upload")
    public ResponseEntity<String> carregarFoto(@RequestParam(name = "arquivo") MultipartFile arquivo){
        String path = upload.upLoadFile(arquivo);
        if(path != null){
            return ResponseEntity.status(201).body(path);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/produto")
    public ResponseEntity<List<Produto>> listarDisponiveis(){
        return ResponseEntity.ok(service.listarDisponiveis());
    }

    @GetMapping("/produto/categoria/{id}")
    public ResponseEntity<List<Produto>> listarPorCategoria(@PathVariable Long id){
        Categoria categoria = new Categoria();
        categoria.setId(id);
        return ResponseEntity.ok(service.listarPorCategoria(categoria));
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<Produto> listarPorId(@PathVariable Long id){
        Produto produto = service.listarPorId(id);
        return ResponseEntity.ok(produto);
    }




}
