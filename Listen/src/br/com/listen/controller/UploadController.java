package br.com.listen.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	
	@RequestMapping("uploadImagem")
	public String formUpload(int cdId,Model model){
		model.addAttribute("cdId",cdId);
		return "cd/uploadImagem";
	}

	@RequestMapping("upload")
		public String uploadImagem(@RequestParam("file") MultipartFile file,int cdId,Model model) throws IOException{
		if(!file.isEmpty()){
				BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
				String local="C:\\Users\\Eduardo\\Documentos\\Facul\\FMU\\3º Semestre\\Técnicas de Programação - Prof Alessandro\\Listen-master\\Listen\\WebContent\\imagens\\CD"+cdId+".png";
				File destination = new File(local);
				ImageIO.write(src, "PNG", destination);
		}
			model.addAttribute("msg","Parabéns você adicionou uma capa para o CD");
			return "redirect:listarCd";
		}
	
	
}
