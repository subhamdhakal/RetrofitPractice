package subham.com.rxkotlinapplication


object Model {
    data class Result(val query: Query)
    data class Query(val searchinfo: SearchInfo)
    data class SearchInfo(val totalhits: Int)

    data class Marvel(val name:String,val realname:String,val team:String,val firstappearance:String,val createdby:String)
}