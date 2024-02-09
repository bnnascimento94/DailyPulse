//
//  SourceListView.swift
//  iosApp
//
//  Created by bnnascimento94 on 09/02/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation


import SwiftUI
import shared

struct SourcesListView: View {

    @ObservedObject var viewModel = SourceViewModel()
    

    
    var body: some View{
        VStack{
            if(viewModel.sources.isEmpty){
                Loader()
            }
            if(!viewModel.sources.isEmpty){
                ScrollView{
                    LazyVStack(spacing:10){
                        ForEach(viewModel.sources, id: \.self){source in
                            SourceItemView(source: source)
                        }
                    }
                }
            }
        
        }.onAppear{
            viewModel.fetchSources()
        }
    }
    
    struct SourceItemView: View{
        var source: Source_
        
        var body: some View{
            VStack(alignment: .leading, spacing: 8){
                Text(source.name).font(.title).fontWeight(.bold)
                Text(source.description_)
                Text(source.language + "-" + source.country).frame(maxWidth: .infinity, alignment: .trailing).foregroundStyle(.gray)
                
            }.padding(16)
        }
    }
    
}
