//
//  SourceScreen.swift
//  iosApp
//
//  Created by bnnascimento94 on 09/02/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI


struct SourceScreen: View {
    
    @Environment(\.dismiss)
    private var dismiss
    
    
    var body: some View{
        NavigationStack{
            SourcesListView()
                .navigationTitle("Sources")
                .toolbar{
                    ToolbarItem(placement: .primaryAction){
                        Button{
                            dismiss()
                        }label: {
                            Text("Done").bold()
                        }
                    }
                }
        }
    }

}
