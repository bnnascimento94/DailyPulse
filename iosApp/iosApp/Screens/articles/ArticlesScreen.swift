//
//  ArticlesScreen.swift
//  iosApp
//
//  Created by bnnascimento94 on 02/02/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared



struct ArticlesScreen: View {
    
    @ObservedObject var viewModel = ArticlesViewModel()
    
    
    var body: some View{
        VStack{
            AppBar()
            
            if(viewModel.articles.isEmpty){
                Loader()
            }
            if(!viewModel.articles.isEmpty){
                ScrollView{
                    LazyVStack(spacing:10){
                        ForEach(viewModel.articles, id: \.self){article in
                            ArticleItemView(article: article)
                        }
                    }
                }
            }
        
        }.onAppear{
            viewModel.fetchArticles(forceFetch: false)
        }
    }
}

struct AppBar:View{
    var body: some View{
        Text("Articles").font(.largeTitle).fontWeight(.bold)
    }
}

struct ArticleItemView: View{
    var article: Article
    
    var body: some View{
        VStack(alignment: .leading, spacing: 8){
            AsyncImage(url: URL(string: article.imageUrl)){phase in
                if phase.image != nil {
                    phase.image!
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                }else if phase.error != nil{
                    Text("Image Load Error")
                }else{
                    ProgressView()
                }
                
            }
            
            Text(article.title).font(.title).fontWeight(.bold)
            Text(article.description_)
            Text(article.date).frame(maxWidth: .infinity, alignment: .trailing).foregroundStyle(.gray)
            
        }.padding(16)
    }
}



struct ErrorMessage: View{
    var message: String
    
    var body: some View{
        Text(message).font(.title)
    }
}


